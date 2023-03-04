package com.hspedu.tomcat.servlet;

import com.hspedu.tomcat.http.HspRequest;
import com.hspedu.tomcat.http.HspResponse;
import com.hspedu.tomcat.utils.WebUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: qxy
 * @Date: 2023/3/4
 * @Description: 计算类
 */
public class hspCalServlet extends hspHttpServlet{
    @Override
    public void doPost(HspRequest request, HspResponse response) {
        doGet(request, response);
    }

    @Override
    public void doGet(HspRequest request, HspResponse response) {
        int num1 = WebUtils.parseInt(request.getParameter("num1"), 0);
        int num2 = WebUtils.parseInt(request.getParameter("num2"), 0);
        int result = num1 + num2;
        OutputStream outputStream = response.getOutputStream();
        try {
            String str = HspResponse.respHeader + "<h1>" + num1 + " + " + num2 + " = " + result + " hspTomcatV3~~<h1>";
            outputStream.write(str.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void destroy() {

    }
}
