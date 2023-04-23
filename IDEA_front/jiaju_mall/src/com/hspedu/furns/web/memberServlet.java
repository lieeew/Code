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
import java.util.Objects;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_DATE;
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

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
        // System.out.println("MemberServlet中的login");
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
            // request.setAttribute("name", username);
            // 老韩思路, 放入到session中
            HttpSession session = request.getSession();
            session.setAttribute("name", username);
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
        // System.out.println("MemberServlet中的register");
        String username = request.getParameter("user-name");
        String pwd = request.getParameter("user-password");
        String email = request.getParameter("user-email");
        String code = request.getParameter("code");
        String key = request.getSession().getAttribute(KAPTCHA_SESSION_KEY).toString();
        // 立即删除验证码, 防止该验证被重复使用
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        // 获取设置的时间
        String key_date = request.getSession().getAttribute(KAPTCHA_SESSION_DATE).toString();
        // System.out.println("key = " + key);
        if (!(!Objects.equals(code, "") && key.equalsIgnoreCase(code))) {
            System.out.println("验证失败");
            request.setAttribute("active", "register");
            request.setAttribute("msg", "验证码错误!!!");
            // 你可以设置任意类型的对象作为属性值。因此，即使是自定义的Java对象也可以被设置为属性值
            request.setAttribute("user", new Member(null, username, email, null));
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
            return;
        }
        // 验证码关卡通过
        if (!memberService.isExistsUsername(username)) {
            if (memberService.register(new Member(null, username, email, pwd))) {
                request.getRequestDispatcher("/views/member/register_ok.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/views/member/register_fail.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
        }
    }

    protected void LogOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // 方法不是删除 session 的方法，而是将 session 的最大非活动时间设置为 -1 秒，表示会话永远不会过期。
        // session.setMaxInactiveInterval(-1)
        // 销毁当前用户的session
        session.invalidate();
        //  重定向 --> 目的 : 刷新首页
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
