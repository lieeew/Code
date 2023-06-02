package com.hspedu.Spring.ioc;

import com.hspedu.Spring.Annotation.Autowired;
import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.Annotation.ComponentScan;
import com.hspedu.Spring.Annotation.Scope;
import com.hspedu.Spring.processor.BeanPostProcessor;
import com.hspedu.Spring.processor.InitializingBean;
import org.apache.commons.lang.StringUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
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
    private Class configClass;
    // 存放初始化信息
    private final ConcurrentHashMap<String, BeanDefinition> BeanDefinitionMap = new ConcurrentHashMap<>();
    // 存放单例对象
    private final ConcurrentHashMap<String, Object> SingletonMap = new ConcurrentHashMap<>();
    private final List<BeanPostProcessor> processorList = new ArrayList<>();

    public HspSpringApplicationContext(Class configClass) {
        beanDefinitionsByScan(configClass);
        Enumeration<String> keys = BeanDefinitionMap.keys();
        while (keys.hasMoreElements()) {
            String beanName = keys.nextElement();
            BeanDefinition beanDefinition = BeanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                // 如果是单例直接出创建对象
                Object bean = creatBean(beanName, beanDefinition);
                SingletonMap.put(beanName, bean);
            }
        }
//        System.out.println("SingletonObjects = " + SingletonMap);
//        System.out.println("BeanDefinitionMap = " + BeanDefinitionMap);
    }

    public void beanDefinitionsByScan(Class configClass) {
        this.configClass = configClass;
        // 1. 拿到配置类上拿到的注解
        ComponentScan componentScan = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        // 要扫描包的路径 com.hspedu.Spring.Annotation
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
                        // 那么是一个bean
                        String beanName = clazz.getAnnotation(Component.class).value();
                        if ("".equals(beanName)) {
                            beanName = StringUtils.uncapitalize(className);
                        }

                        // 判断是不是实现了BeanProcessor接口
                        if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                            // 如果实现了接口
                            processorList.add((BeanPostProcessor) clazz.getDeclaredConstructor().newInstance());
                            continue;
                        }


                        // 开始创建对象
                        BeanDefinition beanDefinition = new BeanDefinition();
                        if (clazz.isAnnotationPresent(Scope.class)) {
                            // singleton, prototype
                            String value = clazz.getDeclaredAnnotation(Scope.class).value();
                            // 设置具体的值
                            if ("".equals(value)) {
                                value = "singleton";
                            }
                            beanDefinition.setScope(value);
                            beanDefinition.setClazz(clazz);

                        } else {
                            beanDefinition.setScope("singleton");
                            beanDefinition.setClazz(clazz);
                        }
                        BeanDefinitionMap.put(beanName, beanDefinition);
                    } else {
//                        System.out.println(clazz + "不是一个bean, 不注入容器之中~~");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 创建bean的专用方法 这里面的事情非常多
     *
     * @param beanName       bean的名字
     * @param beanDefinition 存储bean信息的对象
     * @return 创建好的数据
     */
    public Object creatBean(String beanName, BeanDefinition beanDefinition) {
        Object instance = null;
        try {
            instance = beanDefinition.getClazz().getDeclaredConstructor().newInstance();

            // 实现自动装配
            Field[] fields = beanDefinition.getClazz().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    // 如果某一个属性被 @Autowired 修饰
                    // 爆破!!!
                    field.setAccessible(true);
                    String fieldName = field.getName();
//                    System.out.println("fieldName = " + fieldName);
                    Object o = SingletonMap.get(fieldName);
                    field.set(instance, o);
                }
            }

            System.out.println(beanName + "==" + instance);

            // 后置通知
            for (BeanPostProcessor beanPostProcessor : processorList) {
                instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            }

            // 实现初始化方法
            Class clazz = beanDefinition.getClazz();
            if (InitializingBean.class.isAssignableFrom(clazz)) {
                InitializingBean newInstance = (InitializingBean) instance;
                newInstance.afterPropertiesSet();
            }

            for (BeanPostProcessor beanPostProcessor : processorList) {
                instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
            }

            System.out.println("--------------");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 获取bean的方法
     *
     * @param beanName bean的名字
     * @return 存在容器之中的对象
     * @throws RuntimeException 异常
     */
    public Object getBean(String beanName) throws RuntimeException {
        if (!BeanDefinitionMap.containsKey(beanName)) {
            // 如果BeanDefinitionMap 没有就表示没有这个bean
            throw new RuntimeException("No such bean ");
        }

        BeanDefinition beanDefinition = BeanDefinitionMap.get(beanName);
        if ("singleton".equals(beanDefinition.getScope())) {
            // 如果是单例, 应该不会有没有创建的情况
            return SingletonMap.get(beanName);
        } else {
            // 多例
            return creatBean(beanName, beanDefinition);

        }
    }
}
