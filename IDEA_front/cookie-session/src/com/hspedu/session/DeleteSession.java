package com.hspedu.session;

/**
 * @Author: qxy
 * @Date: 2023/3/14
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteSession", value = "/DeleteSession")
public class DeleteSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("deleteSession ~~~~~");

        HttpSession session = request.getSession();
        session.invalidate(); // 这个是删除当前会话的session

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>删除成功~~~~<h1>");
        writer.flush();
        writer.close();
    }
}
