package com.hspedu.hspspringmvc.context;


import com.hspedu.hspspringmvc.annotation.Controller;
import com.hspedu.hspspringmvc.annotation.RequestMapping;
import com.hspedu.hspspringmvc.annotation.Service;
import com.hspedu.hspspringmvc.handler.HspHandler;
import com.hspedu.hspspringmvc.xml.XMLPaser;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leikooo
 * @create 2023-06-18 14:40
 * @Package com.hspedu.hspspringmvc.context
 * @Description 这个充当 Spring 容器
 */
public class HspWebApplicationContext {
    /**
     * 存放扫描到的所有文件的路径
     */
    private final List<String> classFullPathList = new ArrayList<>();

    /**
     * ioc 容器存放对应被注解标识的类
     */
    public Map<String, Object> ioc = new ConcurrentHashMap<>();

    /**
     * 存放映射关系
     */
    private Map<String, HspHandler> handlerMap = new ConcurrentHashMap();

    public HspWebApplicationContext() {
    }


    /**
     * 初始化方法
     */
    public void init(String xmlFile) {
        String basicPaths = XMLPaser.getBasicPath(xmlFile);
        String[] split = basicPaths.split(",");
        if (split.length < 1) {
            // 没有找到目录文件
            return;
        }
        for (String basicPath : split) {
            scanPackage(basicPath.trim());
        }

        System.out.println("classFullPathList = " + classFullPathList);
        executeInstance();
        System.out.println("ioc = " + ioc);
        initHandlerMapping();
        System.out.println("handlerMap = " + handlerMap);


    }


    /**
     * 扫描之后放入到  classFullPathList 中
     *
     * @param pack 扫描包路径 传入的是类似于 com.example.demo.controller.UserController
     */
    public void scanPackage(String pack) {
        // 拿到 E:\Code\IDEA_project\hsp_SpringMVC02\target\hsp_SpringMVC02\WEB-INF\classes\com\hspedu\Controller
        URL url = this.getClass().getResource("/" + pack.replaceAll("\\.", "/"));
        // System.out.println("url = " + url);
        File file = new File(url.getFile());
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                // 如果是一个目录
                // 迭代遍历下面的类
                scanPackage(pack + "." + f.getName());
            } else {
                // 如果不是一个文件夹
                classFullPathList.add(pack + "." + f.getName().replace(".class", ""));
            }
        }
    }

    /**
     * 实例化扫描到的类 -> 创建对象 -> 放入到 IOC 容器[ConcurrentHashMap]
     */
    public void executeInstance() {
        if (classFullPathList.size() == 0) {
            // 如果集合没有数据直接退出
            return;
        }

        for (String reflectName : classFullPathList) {
            try {
                Class<?> clazz = Class.forName(reflectName);
                if (clazz.isAnnotationPresent(Service.class)) {
                    // 如果被 Service 注解修饰, 那么也可以使用 接口 名称获取
                    Class<?>[] interfaces = clazz.getInterfaces();
                    Object instance = clazz.newInstance();
                    for (Class<?> anInterface : interfaces) {
                        String interfaceName = StringUtils.uncapitalize(anInterface.getSimpleName());
                        ioc.put(interfaceName, instance);
                    }

                    String beanName = clazz.getAnnotation(Service.class).value();
                    if ("".equals(beanName)) {
                        beanName = StringUtils.uncapitalize(clazz.getSimpleName());
                    }
                    ioc.put(beanName, instance);
                } else if (clazz.isAnnotationPresent(Controller.class)) {
                    String beanName = clazz.getAnnotation(Controller.class).value();
                    if ("".equals(beanName)) {
                        beanName = StringUtils.uncapitalize(clazz.getSimpleName());
                    }
                    Object instance = clazz.newInstance();
                    ioc.put(beanName, instance);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 初始化处理映射关系, 也就是 handlerMap
     */
    public void initHandlerMapping() {
        // 遍历 ioc 容器
        if (ioc.size() == 0) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            HspHandler hspHandler = new HspHandler();
            Class<?> clazz = entry.getValue().getClass();
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                    hspHandler.setMethod(method);
                    hspHandler.setController(clazz);
                    hspHandler.setUrl("/hsp_SpringMVC02" + requestMapping.value());

                    // 放入到
                    handlerMap.put(hspHandler.getUrl(), hspHandler);
                }
            }
        }
    }
}
