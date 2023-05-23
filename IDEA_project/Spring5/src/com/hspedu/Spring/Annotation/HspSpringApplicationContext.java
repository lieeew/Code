package com.hspedu.Spring.Annotation;

import com.hspedu.Spring.hspapplicationcontext.HspApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: HspSpringApplicationContext
 * Package: com.hspedu.Spring.Annotation
 *
 * @Author: leikooo
 * @Creat: 2023/5/22 - 11:24
 * @Description: 这个类似模拟Spring的容器
 */
public class HspSpringApplicationContext {
    // 使用反射需要Class类
    private Class configClass;
    // ioc 存放的是通过反射创建的对象(基于注解)
    private final ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public HspSpringApplicationContext(Class configClass) {
        this.configClass = configClass;
        System.out.println("configClass = " + configClass);
        // 1. 拿到配置类上拿到的注解
        ComponentScan componentScan = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        // 要扫描包的路径 com.hspedu.Spring.Annotation
        String path = componentScan.value();
//        System.out.println("path = " + path);
        // com/hspedu/Spring/Annotation 路径
        // 1. 找到类的加载器
        ClassLoader classLoader = HspSpringApplicationContext.class.getClassLoader();
        path = path.replaceAll("\\.", "/");
        // 2. 通过类的加载器， 获得扫描包的资源url
        URL resource = classLoader.getResource(path);
        // resource  file:/E:/github/IDEA_project/Spring5/out/production/Spring5/com/hspedu/Spring/Annotation
//        System.out.println(resource);
        // 3. 将要加载的资源(.class)路径进行遍历 io知识
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                // file1 = E:\github\IDEA_project\Spring5\out\production\Spring5\com\hspedu\Spring\component\MyComponent.class
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
                // 结果 com.hspedu.Spring.component.UserService
                System.out.println("reflectName = " + classFullName);

                // 判断该class文件是否需要注入
                // 1. Class.forName(classFullName) 这个会执行类的静态方法
                // 2. ClassLoader.loadClass(classFullName) 不会执行类的静态方法,轻量级
                // 两个都可以反射加载类
                try {
                    Class<?> aClass = classLoader.loadClass(classFullName);
                    if (aClass.isAnnotationPresent(Component.class) || aClass.isAnnotationPresent(Repository.class)
                            || aClass.isAnnotationPresent(Service.class) || aClass.isAnnotationPresent(Controller.class)) {
                        // 获得注解上面的value属性, 作为key
                        if (aClass.isAnnotationPresent(Component.class)) {
                            String value = aClass.getDeclaredAnnotation(Component.class).value();
                            if (!"".equals(value)) {
                                // 有value属性才进性操作
                                className = value;
                            }
                        } else if (aClass.isAnnotationPresent(Service.class)) {
                            String value = aClass.getDeclaredAnnotation(Service.class).value();
                            if (!"".equals(value)) {
                                // 有value属性才进性操作
                                className = value;
                            }
                        } else if (aClass.isAnnotationPresent(Controller.class)) {
                            String value = aClass.getDeclaredAnnotation(Controller.class).value();
                            if (!"".equals(value)) {
                                // 有value属性才进性操作
                                className = value;
                            }
                        } else if (aClass.isAnnotationPresent(Repository.class)) {
                            String value = aClass.getDeclaredAnnotation(Repository.class).value();
                            if (!"".equals(value)) {
                                // 有value属性才进性操作
                                className = value;
                            }
                        }

                        // 这时反射对象, 放入放容器之中
                        Class<?> clazz = Class.forName(classFullName);
                        Object instance = clazz.newInstance();
                        // 放入到容器之中
                        ioc.put(StringUtils.uncapitalize(className), instance);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    public Object getBean(String key) {
        return ioc.get(key);
    }


    // <T> 表示该方法使用了泛型，T 表示该方法返回一个类型为 T 的对象。
    public <T> T getBean(String key,Class<T> t) {
        return (T) ioc.get(key);
    }
}
