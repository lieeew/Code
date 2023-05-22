package com.hspedu.Spring.Annotation;

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
//        System.out.println("configClass = " + configClass);
    }

}
