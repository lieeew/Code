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

@WebServlet(name = "LoginServlet2", urlPatterns = "/login2")
public class LoginServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet2 被调用了~~~");
        request.getRequestDispatcher("/views/user/user2.html").forward(request, response);
    }
}
