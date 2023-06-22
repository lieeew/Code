package com.hspedu.hspSpringMVC.handler;

import java.lang.reflect.Method;

/**
 * @author leikooo
 * @create 2023-06-22 7:57
 * @Package com.hspedu.hspSpringMVC.handler
 * @Description 记录某一个被 @RequestMapping 标识的类的信息
 */
public class HspHandler {
    private Method method;
    private Class clazz;

    public HspHandler() {
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "HspHandler{" +
                "method=" + method +
                ", clazz=" + clazz +
                '}';
    }
}
