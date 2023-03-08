package com.servlet;

/**
 * @Author: qxy
 * @Date: 2023/3/8
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet 被调用~~");
        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("realPath = " + realPath);
        // 重定向, 发生在浏览器和服务器端, 浏览器解析/
        // 获取工作路径 就是Application Context
        String contextPath = request.getServletContext().getContextPath();
        System.out.println("contextPath = " + contextPath);

        // response.sendRedirect(contextPath + "/views/user/user.html"); 推荐使用这个
        // response.sendRedirect("/webPatch/views/user/user.html");
        // response.sendRedirect("http://localhost:8888/webPatch/views/user/user.html");
        // 使用相对路径 前面不要有/
        // response.sendRedirect("views/user/user.html");
        request.getRequestDispatcher("/views/user/user.html").forward(request, response);

    }
}
