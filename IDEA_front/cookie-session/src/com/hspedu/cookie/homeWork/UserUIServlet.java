package com.hspedu.cookie.homeWork;

/**
 * @Author: qxy
 * @Date: 2023/3/12
 * @Description:
 */

import com.hspedu.cookie.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserUIServlet", urlPatterns = "/UserUIServlet")
public class UserUIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserUIServlet 被调用了~~~~~");

        Cookie[] cookies = request.getCookies();
        Cookie username = CookieUtils.readCookieByName("LoginUsername", cookies);
        Cookie pwd = CookieUtils.readCookieByName("LoginPwd", cookies);
        String LoginUsername = "";
        String LoginPwd = "";
        if (username != null && pwd != null) {
            LoginUsername = username.getValue();
            LoginPwd = pwd.getValue();
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>登录</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/cs/LoginServlet\" method=\"get\">\n" +
                "  u : <input type=\"text\" value= \"" + LoginUsername + "\"name=\"username\"> <br> <br>\n" +
                "  p : <input type=\"password\" value= \"" + LoginPwd + "\"name=\"pwd\"> <br><br>\n" +
                "  <input type=\"submit\" value=\"提交数据\">\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
        writer.flush();
        writer.close();
    }
}
