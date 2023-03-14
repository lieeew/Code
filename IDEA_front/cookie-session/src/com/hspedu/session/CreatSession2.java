package com.hspedu.session;

/**
 * @Author: qxy
 * @Date: 2023/3/14
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreatSession2", urlPatterns = "/CreatSession2")
public class CreatSession2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CreatSession2 ~~~~~");
        HttpSession session = request.getSession();

        String id = session.getId();
        System.out.println("sessionId = " + id);
        // 设置生命周期 60s
        session.setMaxInactiveInterval(60);
        session.setAttribute("email", "zs@qq.com");

    }
}
