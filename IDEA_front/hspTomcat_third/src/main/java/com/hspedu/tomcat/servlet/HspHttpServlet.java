package com.hspedu.tomcat.servlet;

import com.hspedu.tomcat.http.HspRequest;
import com.hspedu.tomcat.http.HspResponse;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description:
 */
public abstract class HspHttpServlet implements HspServlet{

    public void service(HspRequest hspRequest, HspResponse hspResponse) throws Exception {
        if ("GET".equalsIgnoreCase(hspRequest.getMethod())) {
            this.doGet(hspRequest, hspResponse);
        } else if ("POST".equalsIgnoreCase(hspRequest.getMethod())) {
            this.doPost(hspRequest, hspResponse);
        }
    }

    // 模板设计模式
    public abstract void doGet(HspRequest hspRequest, HspResponse hspResponse);

    public abstract void doPost(HspRequest hspRequest, HspResponse hspResponse);
}
