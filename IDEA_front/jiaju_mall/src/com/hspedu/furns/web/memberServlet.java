package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/14
 * @Description:
 */

import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "memberServlet", urlPatterns = "/memberServlet")
public class memberServlet extends BasicServlet {
    // 反射需要空参构造器
    public memberServlet() {

    }

    private MemberService memberService = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //     String action = request.getParameter("action");
    //     if ("login".equals(action)) {
    //         login(request, response);
    //     } else if ("register".equals(action)) {
    //         register(request, response);
    //     }
    // }

    /**
     * 处理会员的登录
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MemberServlet中的login");
        String username = request.getParameter("user-name");
        String password = request.getParameter("user-password");
        // 如果用户没有输入内容, 就直接提交, 后台接收到的数据是""
        Member member = new Member(null, username, null, password);
        Member login = memberService.login(member);
        // Gson gson = new Gson();
        // response.setContentType("application/json;charset=utf-8");
        if (login != null) {
            // String s = gson.toJson(login);
            // System.out.println("客户端 = " + s);
            request.getRequestDispatcher("/views/member/login_ok.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "用户名或者密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
        }
    }

    /**
     * 处理会员的注册
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 一定要看前端页面
        System.out.println("MemberServlet中的register");
        String username = request.getParameter("user-name");
        String pwd = request.getParameter("user-password");
        String email = request.getParameter("user-email");

        if (!memberService.isExistsUsername(username)) {
            if (memberService.register(new Member(null, username, email, pwd))) {
                request.getRequestDispatcher("/views/member/register_ok.html").forward(request, response);
            } else {
                request.getRequestDispatcher("/views/member/register_fail.html").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
        }
    }
}
