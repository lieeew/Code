package com.hspedu.servlet;

/**
 * @Author: qxy
 * @Date: 2023/3/7
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 这个是我们Tomcat真正的工作路劲
        String realPath = request.getServletContext().getRealPath("/"); // 这个/服务器解析成为 http://ip:port/项目名称
        System.out.println("realPath = " + realPath);

        // 这个结果是 Application Context 这个将来可以在服务器渲染技术jsp
        String contextPath = request.getServletContext().getContextPath();
        System.out.println("contextPath = " + contextPath)  ;
    }
}
