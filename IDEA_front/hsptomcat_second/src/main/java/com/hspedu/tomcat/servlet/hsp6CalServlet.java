package com.hspedu.tomcat.servlet;

import com.hspedu.tomcat.http.HspRequest;
import com.hspedu.tomcat.http.HspResponse;
import com.hspedu.tomcat.utils.WebUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: qxy
 * @Date: 2023/3/5
 * @Description:
 */
public class hsp6CalServlet extends hspHttpServlet {
    @Override
    public void doPost(HspRequest request, HspResponse response) {
        doGet(request, response);
    }

    @Override
    public void doGet(HspRequest request, HspResponse response) {
        int num1 = WebUtils.parseInt(request.getParameter("num1"), 0);
        int num2 = WebUtils.parseInt(request.getParameter("num2"), 0);

        int result = num1 * num2;

        OutputStream outputStream = response.getOutputStream();
        String Mes = HspResponse.respHeader + "<h1>结果为 " + num1 + " * " + num2 + " = " + result + "<h1>  ~~反射 + xml调用";
        try {
            outputStream.write(Mes.getBytes());
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
