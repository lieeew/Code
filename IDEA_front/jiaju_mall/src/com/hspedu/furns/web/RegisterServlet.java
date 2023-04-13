package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/12
 * @Description:
 */

import com.hspedu.furns.entity.Member;
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

        if (!memberService.isExistsUsername(username)) {
            // 可以注册
            if (memberService.register(new Member(null, username, pwd, email))) {;
                // 请求转发
                request.getRequestDispatcher("/views/member/register_ok.html").forward(request, response);
            } else {
                request.getRequestDispatcher("/views/member/register_fail.html").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/views/member/login.html").forward(request, response);
        }
    }
}
