package com.hspedu.hspspringmvc.handler;

import java.lang.reflect.Method;

/**
 * @author leikooo
 * @create 2023-06-19 6:37
 * @Package com.hspedu.hspspringmvc.handler
 * @Description
 */
public class HspHandler {
    private String url;
    private Method method;
    private Object controller;

    public HspHandler() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    @Override
    public String toString() {
        return "HspHandler{" +
                "url='" + url + '\'' +
                ", method=" + method +
                ", controller=" + controller +
                '}';
    }
}
