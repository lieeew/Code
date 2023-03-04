package com.hspedu.tomcat.servlet;

import com.hspedu.tomcat.http.HspRequest;
import com.hspedu.tomcat.http.HspResponse;
import com.hspedu.utils.WebUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class HspCalServlet extends HspHttpServlet {
    @Override
    public void doGet(HspRequest request, HspResponse response) {
        //java基础的 OOP 的动态绑定机制..
        //写业务代码，完成计算任务
        int num1 = WebUtils.parseInt(request.getParameter("num1"), 0);
        int num2 = WebUtils.parseInt(request.getParameter("num2"), 0);

        int sum = num1 + num2;

        //返回计算结果给浏览器
        //outputStream 和 当前的socket关联
        OutputStream outputStream = response.getOutputStream();
        String respMes = HspResponse.respHeader
                + "<h1>" + num1 + " + " + num2 + " = " + sum + " HspTomcatV3 - 反射+xml创建</h1>";
        try {
            outputStream.write(respMes.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HspRequest request, HspResponse response) {
        this.doGet(request, response);
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void destroy() {

    }
}
