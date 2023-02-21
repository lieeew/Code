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

public class ServletPayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取到servlet-context对象
        ServletContext servletContext = this.getServletContext();
        // getAttribute从 ServletContext 的域属性空间中获取指定名称的数据。
        Integer visit_count = (Integer) servletContext.getAttribute("visit_count");
        if (visit_count == null) {
            visit_count = 1;
            servletContext.setAttribute("visit_count", 1);
        } else {
            visit_count = visit_count + 1;
            servletContext.setAttribute("visit_count", visit_count);
        }

        // 输出内容
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>浏览器访问的次数为" + visit_count + "</h1>");
        writer.flush();
        writer.close();
    }
}
