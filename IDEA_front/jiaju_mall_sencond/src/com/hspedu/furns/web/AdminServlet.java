package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */

import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.service.AdminService;
import com.hspedu.furns.service.impl.AdminServiceImpl;
import jdk.internal.util.xml.impl.ReaderUTF16;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = "/AdminServlet")
public class AdminServlet extends BasicServlet {
    private final AdminService adminService = new AdminServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("user-password");
        String uname = request.getParameter("user-name");
        Admin admin = new Admin();
        admin.setPassword(password);
        admin.setUsername(uname);
        Admin login = adminService.login(admin);
        if (login != null) {
            // 登录成功
            request.getSession().setAttribute("admin", login);
            request.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(request, response);
        } else {
            request.setAttribute("errMessage", "账号或密码错误");
            request.setAttribute("username", uname);
            request.getRequestDispatcher("/views/manage/manage_login.jsp").forward(request, response);
        }
    }
}
