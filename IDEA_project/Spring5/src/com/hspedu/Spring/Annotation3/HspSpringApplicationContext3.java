package com.hspedu.Spring.Annotation3;

import org.omg.CORBA.PRIVATE_MEMBER;

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

    }
}
