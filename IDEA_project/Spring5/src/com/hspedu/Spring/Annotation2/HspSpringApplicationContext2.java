package com.hspedu.Spring.Annotation2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: HspSpringApplicationContext2
 * Package: com.hspedu.Spring.Annotation2
 *
 * @Author: leikooo
 * @Creat: 2023/5/23 - 11:56
 * @Description:
 */
public class HspSpringApplicationContext2 {
    private Class configClass;

    private final ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<>();

    public HspSpringApplicationContext2(Class configClass) {
        this.configClass = configClass;
        System.out.println("configClass = " + configClass);
        // 拿到注解
        ComponentScan2 annotation = (ComponentScan2) configClass.getDeclaredAnnotation(ComponentScan2.class);
        String path = annotation.value();

        // path = com.hspedu.Spring.component
        System.out.println("path = " + path);

        // 扫描对应路径下的文件
        path = path.replaceAll("\\.", "/");
        // 得到具体路径
        try {
            ClassLoader classLoader = HspSpringApplicationContext2.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            // file:/E:/github/IDEA_project/Spring5/out/production/Spring5/com/hspedu/Spring/component
            System.out.println("resource = " + resource);
            File file = new File(resource.getPath());
            if (!file.isDirectory()) {
                return;
            }
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println("f = " + f);
                // 取出对应的名字 类似于 MyComponent.class的MyComponent
                String absolutePath = f.getAbsolutePath();
                if (!absolutePath.endsWith(".class")) {
                    return;
                }
                String fileName = absolutePath.substring(absolutePath.lastIndexOf("\\") + 1, absolutePath.indexOf(".class"));
                // 获取到名字了
                // System.out.println("fileName = " + fileName);

                // 反射创建对象
                // 类似于 com.hspedu.Spring.component.MyComponent
                String fileFullName = path.replaceAll("/", ".") + "." + fileName;
                System.out.println("fileFullName = " + fileFullName);

                // 判断文件是否有注解
                Class<?> aClass = classLoader.loadClass(fileFullName);
                if (aClass.isAnnotationPresent(Component.class) || aClass.isAnnotationPresent(Controller.class)
                        || aClass.isAnnotationPresent(Repository.class) || aClass.isAnnotationPresent(Service.class)) {

                    // 获得注解上面的value属性, 作为key
                    if (aClass.isAnnotationPresent(Component.class)) {
                        String value = aClass.getDeclaredAnnotation(Component.class).value();
                        if (!"".equals(value)) {
                            // 有value属性才进性操作
                            fileName = value;
                        }
                    } else if (aClass.isAnnotationPresent(Service.class)) {
                        String value = aClass.getDeclaredAnnotation(Service.class).value();
                        if (!"".equals(value)) {
                            // 有value属性才进性操作
                            fileName = value;
                        }
                    } else if (aClass.isAnnotationPresent(Controller.class)) {
                        String value = aClass.getDeclaredAnnotation(Controller.class).value();
                        if (!"".equals(value)) {
                            // 有value属性才进性操作
                            fileName = value;
                        }
                    } else if (aClass.isAnnotationPresent(Repository.class)) {
                        String value = aClass.getDeclaredAnnotation(Repository.class).value();
                        if (!"".equals(value)) {
                            // 有value属性才进性操作
                            fileName = value;
                        }
                    }

                    Object instance = Class.forName(fileFullName).newInstance();
                    ioc.put(StringUtils.uncapitalize(fileName), instance);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getBean(String name, Class<T> clazz) {
        return (T) ioc.get(name);
    }
}
