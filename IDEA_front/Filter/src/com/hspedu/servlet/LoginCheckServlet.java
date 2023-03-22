package com.hspedu.servlet;

/**
 * @Author: qxy
 * @Date: 2023/3/22
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginCheckServlet", urlPatterns = "/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // System.out.println("LoginCheckServlet ~~~");
        // 这里应该还是要到DB验证, 现阶段使用 默认密码123456就通过
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");

        if ("123456".equals(pwd)) {
            System.out.println(userName + "登录成功!!!");
            // 请求转发到 admin.jsp
            request.getRequestDispatcher("/manage/admin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
