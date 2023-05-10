package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/5/4
 * @Description:
 */

import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MemberServlet", urlPatterns = "/MemberServlet")
public class MemberServlet extends BasicServlet {
    private final MemberService memberService = new MemberServiceImpl();

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user-name");
        String password = req.getParameter("user-password");
        String email = req.getParameter("user-email");
        // 验证码
        String captcha = req.getParameter("code");
        Member member = new Member(null, username, password, email);

        if (memberService.isExists(username) != null) {
            // 存在
            req.getRequestDispatcher("/views/member/login.jsp").forward(req, resp);
            return;
        }

        String expected = (String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 立刻删除, 防止重复提交造成错误
        req.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (!expected.equals(captcha)) {
            // 验证码错误
            resp.sendRedirect(req.getContextPath() + "/views/member/register_fail.jsp");
            return;
        }

        // 不存在该用户, 注册
        if (memberService.addMember(member) > 0) {
            // 添加成功
            // 防止重复提交数据
            resp.sendRedirect(req.getContextPath() + "/views/member/register_ok.jsp");
        } else {
            // 添加失败
            resp.sendRedirect(req.getContextPath() + "/views/member/register_fail.jsp");
        }
    }


    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("user-password");
        String uname = req.getParameter("user-name");
        Member member = new Member();
        member.setUsername(uname);
        member.setPassword(password);

        Member login = memberService.login(member);
        if (login != null) {
            // 登录成功
            req.getSession().setAttribute("member", login);
            // 重定向到login_ok页面
            req.getRequestDispatcher("/views/member/login_ok.jsp").forward(req, resp);
        } else {
            // 登录失败
            req.setAttribute("errMessage", "账号或密码错误");
            req.setAttribute("username", uname);
            req.getRequestDispatcher("/views/member/login.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("退出系统~~");
        req.getSession().removeAttribute("member");
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }


    protected void verifyName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Member member = memberService.isExists(name);
        String json = new Gson().toJson(member);
        System.out.println("json = " + json);
        resp.getWriter().println(json);
    }
}
