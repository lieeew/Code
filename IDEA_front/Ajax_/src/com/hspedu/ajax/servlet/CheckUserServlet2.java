package com.hspedu.ajax.servlet;

/**
 * @Author: qxy
 * @Date: 2023/4/8
 * @Description:
 */

import com.google.gson.Gson;
import com.hspedu.ajax.Service.UserService;
import com.hspedu.ajax.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckUserServlet2", urlPatterns = "/CheckUserServlet2")
public class CheckUserServlet2 extends HttpServlet {

    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收Ajax的请求
        String username = request.getParameter("username");
        User user = userService.getUser(username);
        response.setContentType("html/json;charset=utf-8");
        if (user != null) {
            String s = new Gson().toJson(user);
            response.getWriter().write(s);
        } else {
            // 返回一个不存在的user用户
            user = new User(-1, "", "", "");
            String s = new Gson().toJson(user);
            response.getWriter().write(s);
        }
    }
}
