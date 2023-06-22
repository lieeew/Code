package com.hspedu.hspSpringMVC.context;

import com.hspedu.hspSpringMVC.annotation.Controller;
import com.hspedu.hspSpringMVC.annotation.Resource;
import com.hspedu.hspSpringMVC.annotation.Service;
import com.hspedu.hspSpringMVC.xml.XMLPaser;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leikooo
 * @create 2023-06-20 17:23
 * @Package com.hspedu.hspSpringMVC.context
 * @Description 充当 Spring 容器类
 */
public class HspWebApplicationContext {

    /**
     * 存放所有类的对应的可以反射的地址值
     */
    private final List<String> classPathList = new ArrayList<>();

    /**
     * ioc 容器
     */
    public Map<String, Object> ioc = new ConcurrentHashMap<>();


    /**
     * 初始化方法
     */
    public void init() {


    }

    /**
     * 加载 xml 文件配置类下面的属性, 并且把相关的 Reference
     */
    public void loadXmlConfig(String xmlFile) {
        String basicPath = XMLPaser.getBasicPath(xmlFile);
        String[] basicPaths = basicPath.split(",");
        for (String path : basicPaths) {
            scanPacks(path.trim());
        }
        System.out.println("classPathList = " + classPathList);
        executeInstance();
        System.out.println("ioc = " + ioc);
        try {
            autoWired();
            System.out.println("iocF = " + ioc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * 把所有的 Reference 添加到对应的 classPathList 集合之中
     */
    public void scanPacks(String scanPath) {
        URL url = HspWebApplicationContext.class.getClassLoader().getResource(scanPath.trim().replaceAll("\\.", "/"));
        // System.out.println("url = " + url);
        File file = new File(url.getPath());
        File[] files = file.listFiles();
        for (File f : files) {
            // 拿到下面的文件
            if (f.isDirectory()) {
                scanPacks(scanPath + "." + f.getName());
            } else {
                String scanName = scanPath + "." + f.getName().replace(".class", "");
                // System.out.println("scanName = " + scanName);
                classPathList.add(scanName);
            }
        }
    }

    /**
     * 判断某一个个类是否需要注入到容器之中
     */
    public void executeInstance() {
        // 如果 classPathList 是空的化，那么直接推出就 ok
        if (classPathList.size() == 0) {
            return;
        }

        for (String className : classPathList) {
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(Controller.class)) {
                    String beanName = clazz.getAnnotation(Controller.class).value();
                    if ("".equals(beanName)) {
                        beanName = StringUtils.uncapitalize(clazz.getSimpleName());
                    }
                    ioc.put(beanName, clazz.newInstance());
                } else if (clazz.isAnnotationPresent(Service.class)) {
                    Object instance = clazz.newInstance();
                    // 这个还需要支持 接口类型调用
                    // 获取到所是是是实现的接口
                    Class<?>[] interfaces = clazz.getInterfaces();
                    for (Class<?> inter : interfaces) {
                        String innerName = inter.getSimpleName();
                        ioc.put(StringUtils.uncapitalize(innerName), instance);
                    }
                    // 使用 name 注入
                    String beanName = clazz.getAnnotation(Service.class).value();
                    if ("".equals(beanName)) {
                        beanName = StringUtils.uncapitalize(clazz.getSimpleName());
                    }
                    ioc.put(beanName, instance);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 实现自动注入
     */
    public void autoWired() throws Exception {
        // 判断 ioc
        if (ioc.size() == 0) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            // 获取属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Resource.class)) {
                    // 需要爆破
                    field.setAccessible(true);
                    // 先按照名字找，再按照类型
                    String name = field.getName();
                    if (!ioc.containsKey(name)) {
                        // 使用类型名注入
                        Class<?> fieldType = field.getType();
                        name = StringUtils.uncapitalize(fieldType.getSimpleName());
                    }
                    // 设置相关的属性
                    field.set(entry.getValue(), ioc.get(name));
                }
            }
        }
    }

}
