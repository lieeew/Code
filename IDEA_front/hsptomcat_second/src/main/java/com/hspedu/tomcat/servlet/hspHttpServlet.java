package com.hspedu.tomcat.servlet;

import com.hspedu.tomcat.http.HspResponse;
import com.hspedu.tomcat.http.HspRequest;

import java.io.OutputStream;

/**
 * @Author: qxy
 * @Date: 2023/3/4
 * @Description: 老师只保留三个核心方法
 */
public abstract class hspHttpServlet implements hspServlet {

    @Override
    public void service(HspRequest request, HspResponse response) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            this.doGet(request, response);
        } else if ("POST".equalsIgnoreCase(request.getMethod())) {
            this.doPost(request, response);
        }
    }

    // 抽象模板设计模式
    public abstract void doPost(HspRequest request, HspResponse response);

    public abstract void doGet(HspRequest request, HspResponse response);
}
