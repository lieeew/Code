package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/12
 * @Description:
 */

import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private MemberService memberService = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 一定要看前端页面
        String username = request.getParameter("user-name");
        String pwd = request.getParameter("user-password");
        String email = request.getParameter("user-email");

        System.out.println("username" + username + " password" + pwd + " email" + email);
        if (!memberService.isExistsUsername(username)) {
            // 可以注册
            System.out.println(username + "可以注册!!!");
        } else {
            System.out.println(username + "不可以注册");
        }

    }
}
