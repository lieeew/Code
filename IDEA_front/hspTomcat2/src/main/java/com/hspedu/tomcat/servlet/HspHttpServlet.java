package com.hspedu.tomcat.servlet;

import com.hspedu.tomcat.http.HspRequest;
import com.hspedu.tomcat.http.HspResponse;

import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 */
public abstract class HspHttpServlet implements HspServlet {

    @Override
    public void service(HspRequest request, HspResponse response) throws IOException {
        //老师说明 equalsIgnoreCase 比较字符串内容是相同，不区别大小写
        if("GET".equalsIgnoreCase(request.getMethod())) {
            //这里会有动态绑定
            this.doGet(request,response);
        } else if("POST".equalsIgnoreCase(request.getMethod())) {
            this.doPost(request,response);
        }
    }

    //这里我们使用的了模板设计模式 => java 基础的 抽象类专门讲过模板设计模式
    //让HspHttpServlet 子类 HspCalServlet 实现

    public abstract void doGet(HspRequest request, HspResponse response);
    public abstract void doPost(HspRequest request, HspResponse response);
}
