package com.hspedu.hspspringmvc.ioc;

import com.hspedu.hspspringmvc.XML.XMLPaser;
import com.hspedu.hspspringmvc.annotation.AutoWired;
import com.hspedu.hspspringmvc.annotation.Controller;
import com.hspedu.hspspringmvc.annotation.Service;
import com.hspedu.hspspringmvc.handler.HspHandler;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: HspWebApplicationContext
 * Package: com.hspedu.hspspringmvc.ioc
 *
 * @Author: leikooo
 * @Creat: 2023/6/12 - 14:30
 * @Description: 自己定义的一个容器
 */
public class HspWebApplicationContext {

    /**
     * 定义一个集合存储所有类的全路径
     */
    private final List<String> classFullPathList = new ArrayList<String>();
    /**
     * 定义属性 ioc, 存放反射生成的对象
     */
    public final ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<>();

    /**
     * Spring 配置文件的配置文件的地址
     */
    private String contextConfigLocation;

    public HspWebApplicationContext() {
    }

    public HspWebApplicationContext(String contextConfigLocation) {
        this.contextConfigLocation = contextConfigLocation;
    }


    /**
     * @param pack 表示要扫描的包, 会扫描所有的包
     */
    public void scanPackage(String pack) {
        // 得到包所在的工作路径 [绝对路径]
        // 通过类的加载器, 得到指定包对应的工作目录 [绝对路径]
        // 不要直接使用 Junit 测试, 否则 url 为 null
        // 应该使用 Tomcat 这个路径是 : resource = file:/E:/github/IDEA_project/hsp_SpringMVC/target/hsp_SpringMVC/WEB-INF/classes/com/hspedu/controller/
        URL resource = this.getClass().getClassLoader().getResource("/" + pack.replaceAll("\\.", "/"));
        // System.out.println("resource = " + resource);
        // 根据路径进行扫描, 对其进行扫描, 把类的全路径, 保存到 classFullPathList
        String path = resource.getFile();
        // 在 io 中, 把目录视为一个文件
        File file = new File(path);
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                // 是一个目录, 需要递扫描
                scanPackage(pack + "." + f.getName());
            } else {
                // 老韩说明: 这时, 扫描的文件可能是 .class 也可能是其他文件
                // 要得到类的注解需要进行反射
                String classFullPath = pack + "." + f.getName().replace(".class", "");
                classFullPathList.add(classFullPath);
            }
        }
    }

    /**
     * 编写初始化方法
     */
    public void init() {
        String basePackage = XMLPaser.getBasePackage(contextConfigLocation.split(":")[1]);
        System.out.println(contextConfigLocation.split(":")[1]);
        String[] basePackages = basePackage.split(",");
        if (basePackages.length > 0) {
            for (String s : basePackages) {
                scanPackage(s.trim());
            }
        }
        System.out.println("classFullPathList = " + classFullPathList);
        // 将扫描到的类, 反射到 ioc 容器
        executeInstance();
        System.out.println("ioc = " + ioc);
        // 完成自动注入属性
        executeAutoWired();
        System.out.println("装配后 ioc = " + ioc);
    }

    /**
     * 编写方法, 将扫描的类, 在满足条件的情况下 (被 @Controller 或者是被 @Service 注解修饰) ,反射到 ioc 容器之中
     */
    public void executeInstance() {
        // 判断是否扫描到类
        if (classFullPathList.size() == 0) {
            return;
        }
        for (String classFullPath : classFullPathList) {
            try {
                Class<?> clazz = Class.forName(classFullPath);
                if (clazz.isAnnotationPresent(Controller.class)) {
                    // 如果被注解修饰, 那么就可以注入到容器之中
                    Object instance = clazz.newInstance();
                    String className = clazz.getAnnotation(Controller.class).value();
                    if ("".equals(className)) {
                        // 首字母小写的方式
                        className = StringUtils.uncapitalize(clazz.getSimpleName());
                    }
                    // 放入到容器之中
                    ioc.put(className, instance);
                } else if (clazz.isAnnotationPresent(Service.class)) {
                    // 如果是被 @service 修饰的
                    String beanName = clazz.getAnnotation(Service.class).value();
                    Object instance = clazz.newInstance();
                    if ("".equals(beanName)) {
                        // 由于需要根据多个类的接口/类名 「首字母小写」来注入到 ioc 容器之中
                        Class<?>[] interfaces = clazz.getInterfaces();
                        for (Class<?> anInterface : interfaces) {
                            // 拿到首字母小写
                            beanName = StringUtils.uncapitalize(anInterface.getSimpleName());
                            ioc.put(beanName, instance);
                        }
                        // 把类名首字母小写放到 ioc 中
                        ioc.put(beanName, instance);
                    } else {
                        // 如果 @Service 注解有 value 属性
                        ioc.put(beanName, instance);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 编写方法， 完成对属性的自动装配
     */
    public void executeAutoWired() {
        // 如果 ioc 容器里面没有元素
        if (ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            // 获取该元素的所有的属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(AutoWired.class)) {
                    String fieldValue = field.getAnnotation(AutoWired.class).value();
                    Object instance = null;
                    if ("".equals(fieldValue)) {
                        // 如果这个属性被表示了 @AutoWired 注解
                        // 拿到的是变量名
                        // fieldValue = field.getName();
                        // 通过类名首字母小写拿到数据
                        fieldValue = StringUtils.uncapitalize(field.getType().getSimpleName());
                        instance = ioc.get(fieldValue);
                    }
                    // 如果设置了 value 属性
                    if ((instance = ioc.get(fieldValue)) == null) {
                        throw new RuntimeException("不存在对应的你要装配的 bean ");
                    }

                    try {
                        // 开始设置属性
                        field.setAccessible(true);
                        field.set(entry.getValue(), instance);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}