package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/15
 * @Description:
 */
import com.hspedu.furns.entity.Admin;
import com.hspedu.furns.service.AdminService;
import com.hspedu.furns.service.impl.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = "/manage/adminServlet")
public class AdminServlet extends BasicServlet {
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String action = request.getParameter("action"); // login
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = adminService.login(new Admin(null, username, password));
        HttpSession session = request.getSession();
        if (admin != null) {
            // 登录成功
            session.setAttribute("status", "SUCCESS");
            request.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(request, response);
        } else {
            session.setAttribute("status", "FAILURE");
            request.getRequestDispatcher("/views/manage/manage_login.jsp").forward(request, response);
        }
    }
}
