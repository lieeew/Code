package com.hspedu.ajax.servlet;

/**
 * @Author: qxy
 * @Date: 2023/4/6
 * @Description:
 */

import com.google.gson.Gson;
import com.hspedu.ajax.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckUserServlet", urlPatterns = "/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CheckUserServlet~~~");

        String uname = request.getParameter("uname");
        System.out.println("uname=" + uname);

        response.setContentType("text/html;charset=UTF-8");
        if ("king".equals(uname)) {
            User king = new User(1, "king", "king@gmail.com", "123123");
            String s = new Gson().toJson(king);
            System.out.println(s);

            response.getWriter().write(s);
        } else {
            response.getWriter().write("");
        }
    }
}
