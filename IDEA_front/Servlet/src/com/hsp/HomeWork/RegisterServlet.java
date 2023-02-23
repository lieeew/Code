package com.hsp.HomeWork;

/**
 * @Author: qxy
 * @Date: 2023/2/23
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/registerServlet", name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pwd1 = request.getParameter("pwd1");
        String pwd2 = request.getParameter("pwd2");

         String[] sports = request.getParameterValues("sport");
        StringBuffer sb = new StringBuffer();
        for (String sport : sports) {
            sb.append(sport).append("\n");
        }

        String gender = request.getParameter("gender");
        String[] cities = request.getParameterValues("city");
        StringBuffer sb2 = new StringBuffer();
        for (String city : cities) {
            sb2.append(city).append("\n");
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("username = " + username + "<br><br>" + "pwd = " + pwd1 + "<br><br>" + "pwd = " + pwd2 + "<br><br>");
        writer.println("你喜欢的项目 = " + sb + "<br><br>" + "你的性别 = " + gender + "<br><br>" + "你喜欢的城市 = " + sb2);

        // User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/110.0
        String s = request.getHeader("User-Agent").split("[(,)]")[1].split(";")[2].trim(); // trim去掉左右空格
        writer.println("<br><br>计算机位数 = " + s); //x64
        writer.flush();
        writer.close();
    }
}
