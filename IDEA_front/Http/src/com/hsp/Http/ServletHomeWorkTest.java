package com.hsp.Http;

/**
 * @Author: qxy
 * @Date: 2023/2/21
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/homework")
public class ServletHomeWorkTest extends HttpServlet {

    // 使用同一套逻辑
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //重定向到bing 302
//        response.sendRedirect("h1.html");

        // 500报错
//        int[] arr = new int[2];
//        arr[2] = 1;

        // 200
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>恭喜我自己!!!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
