package com.hspedu.tomcat.servlet;

import com.hspedu.tomcat.http.HspRequest;
import com.hspedu.tomcat.http.HspResponse;
import com.hspedu.tomcat.utils.WebUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description:
 */
public class OkServlet extends HspHttpServlet {
    public void doGet(HspRequest hspRequest, HspResponse hspResponse) {
        doPost(hspRequest, hspResponse);
    }

    public void doPost(HspRequest hspRequest, HspResponse hspResponse) {
        OutputStream outputStream = hspResponse.getOutputStream();
        int num1 = WebUtils.parseInt(hspRequest.getParameter("num1"), 0);
        int num2 = WebUtils.parseInt(hspRequest.getParameter("num2"), 0);
        int result = num1 + num2;
        String str = HspResponse.Header + "<h1>结果 : " + num1 + " + " + num2 + " = " + result + " 反射 + dom4j调用~~~~<h1> ";
        try {
            outputStream.write(str.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void init() throws Exception {

    }

    public void destroy() {

    }
}
