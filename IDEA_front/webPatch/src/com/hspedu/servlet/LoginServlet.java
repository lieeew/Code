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

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用转发
        // 第一个/ 被服务器解析为 /webPatch/ 但是理解为解析为 http://ip:port/项目名称, 由于是发生在服务器的行为
        request.getRequestDispatcher("/views/user/user.html").forward(request, response);
        request.getRequestDispatcher("views/user/user.html").forward(request, response); // 不写/也是可以的
        request.getRequestDispatcher("http://localhost:8888/webPatch/views/user/user.html").forward(request, response);
        System.out.println("Servlet被调用了~~~");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
