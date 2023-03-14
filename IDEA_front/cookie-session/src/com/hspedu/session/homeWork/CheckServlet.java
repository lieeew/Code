package com.hspedu.session.homeWork;

/**
 * @Author: qxy
 * @Date: 2023/3/14
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckServlet", value = "/CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CheckServlet ~~~~");
        HttpSession session = request.getSession();
        if (session.getAttribute("pwd") == null) {
            response.sendRedirect("/cs/login2.html"); // 直接转发到login2.html
            return; // 在重定向之后加上了return语句，确保在重定向之后立即结束方法的执行，并且在输出完响应内容后关闭了输出流，以避免响应已经被提交的情况。
        }

        String pwd = (String) session.getAttribute("pwd");
        System.out.println("pwd = " + pwd);
        if ("666666".equals(pwd)) {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("<h1>登录成功!!!<h1>");
            writer.flush();
            writer.close();
        } else {
            response.sendRedirect("/cs/fail.html");
        }
    }
}
