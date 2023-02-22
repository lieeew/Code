package com.hsp;

/**
 * @Author: qxy
 * @Date: 2023/2/21
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取到servlet-context对象
        ServletContext servletContext = this.getServletContext();
        int visit_count = ServletUtils.count_nums(servletContext);
        // 输出内容
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>浏览器访问的次数为" + visit_count + "</h1>");
        writer.flush();
        writer.close();
    }
}
