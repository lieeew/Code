package com.hspEdu.Ajax.servlet;

/**
 * @Author: qxy
 * @Date: 2023/4/5
 * @Description:
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hspEdu.Ajax.entity.User;

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
        System.out.println("CheckUserServlet ~~~~");

        //接收Ajax的数据
        String uname = request.getParameter("uname");
        // System.out.println("uname = " + uname);

        response.setContentType("text/html;charset=utf-8");
        if ("king".equals(uname)) { //用户名不可用
            User king = new User(1, "king", "666", "king@souhu.com");
            // JavaBean --> JSON
            System.out.println("111");
            Gson gson = new Gson();
            System.out.println("222");
            String strString = gson.toJson(king);
            // System.out.println(strString);
            response.getWriter().write(strString);

        } else {
            // 返回一个空串
            response.getWriter().write("");
        }
    }
}
