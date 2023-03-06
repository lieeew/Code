package com.hsp.servlet;

import com.hsp.Tomcat.http.HspRequest;
import com.hsp.Tomcat.http.HspResponse;
import com.hsp.Tomcat.servlet.HspHttpServlet;
import com.hsp.utils.WebUtils;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: qxy
 * @Date: 2023/2/28
 * @Description:
 */
public class HspCalServlet extends HspHttpServlet {

    @Override
    public void doGet(HspRequest request, HspResponse response) {
        int num1 = WebUtils.parseInt(request.getParameterts("num1"), 0);
        int num2 = WebUtils.parseInt(request.getParameterts("num2"), 0);

        int result = num1 + num2;
        // 返回计算结果
        OutputStream outputStream = response.getOutputStream();
        String respMes = HspResponse.respHeader
                + "<h1>" + num1 + " + " + num2 + " = " + result + " hspTomcat V3版本</h1>";
        try {
            outputStream.write(respMes.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
