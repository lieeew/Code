package com.hsp.RequestForwarding;

/**
 * @Author: qxy
 * @Date: 2023/2/23
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DownServlet", urlPatterns = "/DownServlet")
public class DownServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/x-tar;charset=utf-8");
//        PrintWriter writer = response.getWriter();
//        writer.println("ok~~");
//        writer.flush();
//        writer.close();

        //1. 因为请求重定向 是将请求返回给 Location: /downServletNew
        // 2. 所以浏览器来解析 /downServletNew, 而不是服务端解析
        // 3. 会以当前浏览器的地址栏的 主机+/downServletNew 也就是
        String contextPath = getServletContext().getContextPath();
        System.out.println("主机名 = " + contextPath);
        // response.sendRedirect( contextPath + "/DownServletNew");

//        response.setStatus(302);
//        response.setHeader("Location", "/Servlet/DownServletNew");
    }
}
