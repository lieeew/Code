package com.hsp.servletReqyest;

/**
 * @Author: qxy
 * @Date: 2023/2/22
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/homeWork")
public class homeWork extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Cookie: JSESSIONID=F7664E1EB13A69F0354A9016A7EEA329; Idea-fa2b9bde=dfa51709-3b09-4132-beb8-8622ff022a24
        String regStr = request.getHeader("Cookie").split("[=,;]")[1];
        System.out.println("regStr = " + regStr);
        // 获取浏览器
        // User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/110.0
        String header = request.getHeader("User-Agent");
        String[] split = header.split(" ");
        System.out.println("浏览器 = " + split[split.length - 1].split("/")[0]);

    }
}
