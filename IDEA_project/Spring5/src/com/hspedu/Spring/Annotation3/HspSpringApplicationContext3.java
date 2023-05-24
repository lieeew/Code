package com.hspedu.Spring.Annotation3;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: HspSpringApplicationContext3
 * Package: com.hspedu.Spring.Annotation3
 *
 * @Author: leikooo
 * @Creat: 2023/5/23 - 14:44
 * @Description:
 */
public class HspSpringApplicationContext3 {
    private Class configure;
    private final ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public HspSpringApplicationContext3(Class configure) {
        this.configure = configure;
        ComponentScan3 annotation = (ComponentScan3) configure.getDeclaredAnnotation(ComponentScan3.class);
        String path = annotation.value();
        System.out.println("path = " + path);

        path = path.replaceAll("\\.", "/");
        ClassLoader classLoader = HspSpringApplicationContext3.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        // file:/E:/github/IDEA_project/Spring5/out/production/Spring5/com/hspedu/Spring/component
        System.out.println("resource = " + resource);

        File file = new File(resource.getPath());
        if (!file.isDirectory()) {
            return;
        }
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.getAbsolutePath().endsWith(".class")) {
                return;
            }

            String absolutePath = f.getAbsolutePath();
            // E:\github\IDEA_project\Spring5\out\production\Spring5\com\hspedu\Spring\component\UserDAO.class
            // System.out.println("absolutePath = " + absolutePath);
            String fileName = absolutePath.substring(absolutePath.lastIndexOf("\\") + 1, absolutePath.indexOf(".class"));
            // System.out.println("fileName = " + fileName);

            // 使用反射创建对象
            String fileFullName = path.replaceAll("/", ".") + "." + fileName;
            // System.out.println("fileFullName = " + fileFullName);

            // 判断是否有注解
            try {
                Class<?> aClass = classLoader.loadClass(fileFullName);
                if (aClass.isAnnotationPresent(Component.class) || aClass.isAnnotationPresent(Controller.class) || aClass.isAnnotationPresent(Repository.class) || aClass.isAnnotationPresent(Service.class)) {
                    // 被注解标识了
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

                    // 造对象放入放到集合之中
                    Object instance = Class.forName(fileFullName).newInstance();
                    ioc.put(StringUtils.uncapitalize(fileName), instance);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


}
