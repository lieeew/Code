package com.hspedu.Spring.ioc;

import com.hspedu.Spring.Annotation.Autowired;
import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.Annotation.ComponentScan;
import com.hspedu.Spring.Annotation.Scope;
import com.hspedu.Spring.component.MonsterDAO;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
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
    private final ConcurrentHashMap<String, BeanDefinition> BeanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
    // 定义一个SingletonObjects  ->  存放单例对象
    private final ConcurrentHashMap<String, Object> SingletonObjects = new ConcurrentHashMap<String, Object>();
    // ioc 存放的是通过反射创建的对象(基于注解)
    private final ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<String, Object>();

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
                Object bean = createBean(beanDefinition);
                SingletonObjects.put(beanName, bean);
            }
        }

        System.out.println("SingletonObjects = " + SingletonObjects);
        System.out.println("BeanDefinitionMap = " + BeanDefinitionMap);
    }

    /**
     * 返回Bean对象, 有三种情况 , 这种写法初始化的位置不对!!!
     *
     * @param key key
     * @return 对象
     */
//    public Object getBean(String key) throws InstantiationException, IllegalAccessException {
//        BeanDefinition beanDefinition = BeanDefinitionMap.get(key);
//        if (beanDefinition == null) {
//            throw new RuntimeException("No BeanDefinition~~");
//        }
//
//        String scope = beanDefinition.getScope();
//        if ("singleton".equals(scope)) {
//            if (SingletonObjects.containsKey(key)) {
//                return SingletonObjects.get(key);
//            } else {
//                Class clazz = beanDefinition.getClazz();
//                Object instance = clazz.newInstance();
//                SingletonObjects.put(key, instance);
//                return instance;
//            }
//        } else if ("prototype".equals(scope)) {
//            Class clazz = beanDefinition.getClazz();
//            return clazz.newInstance();
//        } else {
//            System.out.println("~~");
//        }
//        return null;
//    }

    /**
     * 创建bean对象
     */
    private Object createBean(BeanDefinition beanDefinition) {
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
                    Object bean =  getBean(name);
                    field.set(instance, bean);
                }
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object getBean(String beanName) {
        if (!BeanDefinitionMap.containsKey(beanName)) {
            // 没有这个beanName就直接抛出异常
            throw new RuntimeException("No BeanDefinition~~");
        }

        if ("singleton".equals(BeanDefinitionMap.get(beanName).getScope())) {
            return SingletonObjects.get(beanName);
        } else {
            BeanDefinition beanDefinition = BeanDefinitionMap.get(beanName);
            return createBean(beanDefinition);
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
                            System.out.println("这个是一个SpringBean bean = " + clazz + " 类名 " + className);
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
                                System.out.println("name = " + name);
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

