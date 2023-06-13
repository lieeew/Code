package com.hspedu.hspspringmvc.handler;

import java.lang.reflect.Method;

/**
 * ClassName: HspHandler
 * Package: com.hspedu.hspspringmvc.handler
 *
 * @Author: leikooo
 * @Creat: 2023/6/13 - 14:16
 * @Description: 用于记录请求的 url 和控制器方法映射的关系
 */
public class HspHandler {
    private String  url;
    private Object controller;
    private Method method;


    public HspHandler(String url, Object controller, Method method) {
        this.url = url;
        this.controller = controller;
        this.method = method;
    }

    // 生成getter 和 setter 方法


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "HspHandler{" +
                "url='" + url + '\'' +
                ", controller=" + controller +
                ", method=" + method +
                '}';
    }
}
