package com.hspedu.cookie.homeWork;

/**
 * @Author: qxy
 * @Date: 2023/3/12
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet ~~~使用成功");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        System.out.println("username = " + username);
        System.out.println("pwd = " + pwd);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if ("tom".equals(username) && "123456".equals(pwd)) {
            Cookie cookie1 = new Cookie("LoginUsername", username);
            Cookie cookie2 = new Cookie("LoginPwd", pwd);

            cookie1.setMaxAge(180);
            cookie2.setMaxAge(180);

            response.addCookie(cookie1);
            response.addCookie(cookie2);

            writer.println("<h1>登录成功~~</h1>");
        } else {
            writer.println("<h1>登录失败~~~~~<h1>");
        }
        writer.flush();
        writer.close();
    }
}
