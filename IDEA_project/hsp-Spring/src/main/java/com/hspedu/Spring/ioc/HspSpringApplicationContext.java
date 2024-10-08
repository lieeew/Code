package com.hspedu.Spring.ioc;

import com.hspedu.Spring.Annotation.Autowired;
import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.Annotation.ComponentScan;
import com.hspedu.Spring.Annotation.Scope;
import com.hspedu.Spring.component.MonsterDAO;
import com.hspedu.Spring.processor.BeanPostProcessor;
import com.hspedu.Spring.processor.InitializingBean;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: HspSpringApplicationContext
 * Package: com.hspedu.Spring.ioc
 *
 * @Author: leikooo
 * @Creat: 2023/5/29 - 16:39
 * @Description:
 */
public class HspSpringApplicationContext {
    // 使用反射需要Class类
    private Class configClass;

    // 定义一个属性 BeanDefinitionMap  -> 存放BeanDefinition
    private final ConcurrentHashMap<String, BeanDefinition> BeanDefinitionMap = new ConcurrentHashMap<>();

    // 定义一个SingletonObjects  ->  存放单例对象
    private final ConcurrentHashMap<String, Object> SingletonObjects = new ConcurrentHashMap<>();

    // 定义一个 ArrayList 存放 实现BeanPostProcessor的类
    /*
        1. 为了方便, 老韩这里将后置处理器放到ArrayList中
        2. 原生的Spring容器中, 对后置处理器走的还是 getBean,creatBean 但是需要我们在 SingletonObjects 加入相应的逻辑
        3. 这里使用ArrayList就简化了
     */
    private final List<BeanPostProcessor> beanPostProcessorList = new ArrayList<BeanPostProcessor>();

    public HspSpringApplicationContext(Class configClass) {
        beanDefinitionByScan(configClass);
        Enumeration<String> keys = BeanDefinitionMap.keys();
        while (keys.hasMoreElements()) {
            // 得到beanName
            String beanName = keys.nextElement();
            // 通过beanName 得到对应的beanDefinition对象
            BeanDefinition beanDefinition = BeanDefinitionMap.get(beanName);
            // 判断 是单例还是多例
            String scope = beanDefinition.getScope();
            if ("singleton".equals(scope)) {
                // 单例直接创建
                Object bean = createBean(beanName, beanDefinition);
                if (!SingletonObjects.containsKey(beanName)) {
                    // 如果已经创建了, 就不用再进行创建了
                    SingletonObjects.put(beanName, bean);
                }
            }
        }
//        System.out.println("SingletonObjects = " + SingletonObjects);
//        System.out.println("BeanDefinitionMap = " + BeanDefinitionMap);
    }

    /**
     * 创建bean对象
     */
    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        // 拿到class对象
        try {
            Class clazz = beanDefinition.getClazz();
            // 反射创建对象
            Object instance = clazz.getDeclaredConstructor().newInstance();
            // 在这里实现自动依赖注入就非常的合适

            // 获取对应Java类的属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);
                    String name = field.getName();
//                    System.out.println("name = " + name);
                    Object bean = getBean(name);
                    // 传入对象
                    field.set(instance, bean);
                }
            }
            System.out.println("=====bean创建好实例=====  " + instance);

            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                // 在后置处理器的before方法, 可以对容器实例进行处理
                // 然后返回处理后的bean实例, 相当于前置处理
                Object current = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
                instance = current != null ? current : instance;
            }

            // 这里可以执行初始化方法
            // instanceof 表示判断某个对象运行类型是不是 某个类型或者某个子类型
            // 这里使用过到 接口编程
            if (instance instanceof InitializingBean) {
                InitializingBean initializingBean = (InitializingBean) instance;
                initializingBean.afterPropertiesSet();
            }

            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                // 我感觉这里实现aop非常完美, 直接修改instance变成代理对象, 调用方法
                Object current = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
                instance = current != null ? current : instance;
            }
            System.out.println("--------------------------------");
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Object getBean(String beanName) {
        if (!BeanDefinitionMap.containsKey(beanName)) {
            // 没有这个beanName就直接抛出异常
            throw new RuntimeException("No BeanDefinition~~");
        }

        if ("singleton".equals(BeanDefinitionMap.get(beanName).getScope())) {
            if (SingletonObjects.containsKey(beanName)) {
                return SingletonObjects.get(beanName);
            } else {
                BeanDefinition beanDefinition = BeanDefinitionMap.get(beanName);
                Object instance = createBean(beanName, beanDefinition);
                SingletonObjects.put(beanName, instance);
                return instance;
            }
        } else {
            BeanDefinition beanDefinition = BeanDefinitionMap.get(beanName);
            return createBean(beanName, beanDefinition);
        }
    }


    /**
     * 该方法完成对指定包的扫描, 并将Bean信息封装到 BeanDefinition对象, 并放入到Map之中
     *
     * @param configClass 配置对象
     */
    public void beanDefinitionByScan(Class configClass) {
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

                try {
                    Class<?> clazz = classLoader.loadClass(classFullName);
                    if (clazz.isAnnotationPresent(Component.class)) {
                        // 获得注解上面的value属性, 作为key
                        if (clazz.isAnnotationPresent(Component.class)) {
                            // 如果该类使用了@Component
//                            System.out.println("这个是一个SpringBean bean = " + clazz + " 类名 " + className);

                            // 说明 我们这里不能使用 instanceof 来判断 clazz 是否实现了 BeanPostProcessor
                            // 因为: clazz不是一个实例对象, 而是一个类对象, 使用 isAssignableFrom
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                BeanPostProcessor beanPostProcessor = (BeanPostProcessor) clazz.getDeclaredConstructor().newInstance();
                                // 加入到集合之中
                                beanPostProcessorList.add(beanPostProcessor);
                                // 不需要在往下走, 因为放入到 BeanDefinitionMap 之后还回执行creat方法
                                continue;
                            }

                            // 先得到beanName
                            // 1. 得到 Component 注解
                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                            // 2. 的配置value值, 疑问 如果程序员没有配置value
                            String beanName = componentAnnotation.value();
                            if ("".equals(beanName)) {
                                // 如果没有指定值, 那么直接首字母小写
                                // 注意这里的 StringUtils 是  org.apache.commons.lang 目录下面的
                                beanName = StringUtils.uncapitalize(className);
                                String name = clazz.getName();
//                                System.out.println("name = " + name);
                            }
                            // 3. 这里把bean信息封装到 BeanDefinitionMap
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(clazz);
                            // 4. 获取到Scope的值
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                String value = scopeAnnotation.value();
                                if ("".equals(value)) {
                                    value = "singleton";
                                }
                                beanDefinition.setScope(value);
                            } else {
                                // 没有配置scope就获取其他配置的值
                                beanDefinition.setScope("singleton");
                            }
                            // 5. 将beanDefinition 放到Map
                            BeanDefinitionMap.put(beanName, beanDefinition);
                        }
                    } else {
                        System.out.println("这不是一个SpringBean bean = " + clazz + " 类名 " + className);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

