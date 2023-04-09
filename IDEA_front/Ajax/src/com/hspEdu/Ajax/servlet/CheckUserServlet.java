package com.hspEdu.Ajax.Servlet;

/**
 * @Author: qxy
 * @Date: 2023/4/8
 * @Description:
 */

import com.google.gson.Gson;
import com.hspEdu.Ajax.entity.User;
import com.hspEdu.Ajax.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckUserServlet", urlPatterns = "/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {

    private UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        response.setContentType("text/html;charset=UTF-8");
        User user = userService.getUserByName(username);
        if (user != null) {
            String s = new Gson().toJson(user);
            response.getWriter().write(s);
        } else {
            user = new User(-1, "", "", "");
            String s = new Gson().toJson(user);
            response.getWriter().write(s);
        }
    }
}
