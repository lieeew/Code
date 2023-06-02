package com.hspedu.Spring.ioc;

import com.hspedu.Spring.Annotation.Autowired;
import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.Annotation.ComponentScan;
import com.hspedu.Spring.Annotation.Scope;
import com.hspedu.Spring.processor.BeanPostProcessor;
import com.hspedu.Spring.processor.InitializingBean;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: HspSpringApplicationContext
 * Package: com.hspedu.Spring.ioc
 *
 * @Author: leikooo
 * @Creat: 2023/6/1 - 12:12
 * @Description:
 */
public class HspSpringApplicationContext {
    private Class configure;
    private final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
    // 注意这里是object
    private final ConcurrentHashMap<String, Object> SingletonMap = new ConcurrentHashMap<String, Object>();
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
    public HspSpringApplicationContext(Class configure) {
        beanDefinitionByScan(configure);
        // 拿到已经整好的定义bean
        Enumeration<String> keys = beanDefinitionMap.keys();
        while (keys.hasMoreElements()) {
            String beanName = keys.nextElement();
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                // 如果是单例直接创建, 放到单例池
                if (!SingletonMap.containsKey(beanName)) {
                    SingletonMap.put(beanName, creatBean(beanName, beanDefinition));
                }
            }
        }
    }

    public Object creatBean(String beanName, BeanDefinition beanDefinition) {

        Object bean = null;
        try {
            bean = beanDefinition.getClazz().getDeclaredConstructor().newInstance();

            // 这里实现自动装配
            Field[] fields = bean.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    // 如果某一个属性是标识了 @Autowired 注解
                    String fieldName = field.getName();
                    field.setAccessible(true);
                    Object o = SingletonMap.get(fieldName);
                    if (o == null) {
                        BeanDefinition definition = beanDefinitionMap.get(fieldName);
                        SingletonMap.put(fieldName, definition);
                        o = creatBean(fieldName, definition);
                    }
                    field.set(bean, o);
                }
            }
            System.out.println("=======初始化======" + bean);

            // 实现后置通知
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                bean = beanPostProcessor.postProcessBeforeInitialization(bean, beanName);
            }

            // 实现初始化方法
            if (InitializingBean.class.isAssignableFrom(bean.getClass())) {
                ((InitializingBean) bean).afterPropertiesSet();
            }

            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                bean = beanPostProcessor.postProcessAfterInitialization(bean, beanName);
            }

            System.out.println("---------------------");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return bean;
    }

    // 获取bean
    public Object getBean(String beanName) {
        if (!beanDefinitionMap.containsKey(beanName)) {
            throw new RuntimeException("NO SUCH BEAN");
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if ("singleton".equals(beanDefinition.getScope())) {
            return SingletonMap.get(beanName);
        } else {
            return creatBean(beanName, beanDefinition);
        }
    }

    // 扫描装配
    public void beanDefinitionByScan(Class configure) {
        this.configure = configure;
        if ((configure != null) && configure.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = (ComponentScan) configure.getDeclaredAnnotation(ComponentScan.class);
            String path = componentScan.value();
//        System.out.println("path = " + path);
            // com/hspedu/Spring/Annotation 路径
            // 1. 找到类的加载器 --> APP类加载器
            ClassLoader classLoader = HspSpringApplicationContext.class.getClassLoader();
            path = path.replaceAll("\\.", "/");
            // 2. 通过类的加载器， 获得扫描包的资源url
            URL resource = classLoader.getResource(path);
            // 3. 将要加载的资源(.class)路径进行遍历 io知识
            File file = new File(resource.getFile());
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    String absolutePath = f.getAbsolutePath();
                    if (!absolutePath.endsWith(".class")) {
                        // 如果不是以.class结尾的就不进行下面的操作
                        return;
                    }
                    // 反射需要 的是 com.hspedu.Spring.component.MyComponent
                    // 获取到类名 类似于 MyComponent
                    String className = absolutePath.substring(absolutePath.lastIndexOf("\\") + 1, absolutePath.lastIndexOf(".class"));
                    // 反射需要的是 全类名
                    String classFullName = path.replaceAll("/", ".") + "." + className;
                    // 造对象, 放到单例池
                    try {
                        Class<?> clazz = Class.forName(classFullName);
                        if (clazz.isAnnotationPresent(Component.class)) {
                            String beanName = clazz.getDeclaredAnnotation(Component.class).value();
                            if ("".equals(beanName)) {
                                // 如果没写有指定beanName那么就应类名小写代替
                                beanName = StringUtils.uncapitalize(className);
                            }

                            // 这里判断是不是后置处理器
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                // 如果实现了 BeanPostProcessor 接口
                                beanPostProcessors.add((BeanPostProcessor) clazz.getDeclaredConstructor().newInstance());
                                // 就不需要在放到 beanDefinitionMap 里面
                                continue;
                            }
                            BeanDefinition beanDefinition = new BeanDefinition();

                            beanDefinition.setClazz(clazz);
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                String scope = clazz.getDeclaredAnnotation(Scope.class).value();
                                if ("".equals(scope)) {
                                    // 没有指定默认singleton
                                    scope = "singleton";
                                }
                                beanDefinition.setScope(scope);
                            } else {
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }

                    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                             IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}