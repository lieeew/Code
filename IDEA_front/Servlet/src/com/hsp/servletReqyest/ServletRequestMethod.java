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
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/requestMethods")
public class ServletRequestMethod extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String host = request.getHeader("Host");
        request.setCharacterEncoding("utf-8"); // 这个需要在前面写, 就不会乱码
        String username = request.getParameter("username");

        System.out.println("username = " + username);
        System.out.println("host = " + host);

        // text/html 本质上就是http响应头
        /*
        再次理解 Content-Type
        浏览器会根据数据类型进行解析
        text/plain 以存文本解析
        application/x-tar 会下载
         */
        response.setContentType("application/x-tar;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>用户的名字 = " + username + "</h1>");
        writer.flush();
        writer.close();
    }
}
