package com.hspedu.cookie;

/**
 * @Author: qxy
 * @Date: 2023/3/8
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReadCookie2", urlPatterns = "/ReadCookie2")
public class ReadCookie2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                System.out.println("name : " + cookie.getName() + "\t" + "value" + cookie.getValue());
                System.out.println();
            }
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("读取成功~~~~");
        writer.flush();
        writer.close();
    }
}
