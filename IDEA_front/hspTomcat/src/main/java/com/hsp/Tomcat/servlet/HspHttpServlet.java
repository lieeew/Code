package com.hsp.Tomcat.servlet;


import com.hsp.Tomcat.http.HspRequest;
import com.hsp.Tomcat.http.HspResponse;

import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/2/28
 * @Description:
 */
public abstract class HspHttpServlet implements HspServlet {

    @Override
    public void service(HspRequest request, HspResponse response) throws IOException {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            // this 这里有oop的动态绑定机制
            this.doGet(request, response); // 这个this会动态绑定到继承了这个类的实例
        } else if ("POST".equalsIgnoreCase(request.getMethod())) {
            this.doPost(request, response);
        }
    }

    // 我们使用了模板设计模式
    // 让HtpHttpServlet子类
    public abstract void doGet(HspRequest request, HspResponse response);

    public abstract void doPost(HspRequest request, HspResponse response);
}
