package com.hspedu.ajax.servlet;

/**
 * @Author: qxy
 * @Date: 2023/4/7
 * @Description:
 */

import com.google.gson.Gson;
import com.hspedu.ajax.Service.UserService;
import com.hspedu.ajax.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckServlet", urlPatterns = "/CheckServlet")
public class CheckServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CheckServlet~~~~");

        String uname = request.getParameter("uname");
        System.out.println("uname: " + uname);
//        System.out.println("1111");
        User user = userService.getUser(uname);
//        System.out.println("222");
        System.out.println("user = " + user);
        response.setContentType("text/html;charset=UTF-8");
        if (user != null) { // 用户存在返回user的JSON格式
            Gson gson = new Gson();
            String s = gson.toJson(user, User.class);
            response.getWriter().write(s);
        } else {
            response.getWriter().write("");
        }
    }
}
