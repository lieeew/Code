package com.hsp.requestSecond;

/**
 * @Author: qxy
 * @Date: 2023/2/23
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/checkServlet2")
public class checkServletRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取名字
        request.setCharacterEncoding("utf-8"); // 设置之后不会乱码
        String username = request.getParameter("username");
        if ("tom".equals(username)) {
            request.setAttribute("role", "管理员");
        } else {
            request.setAttribute("role", "普通用户");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/manageServlet2");
        requestDispatcher.forward(request, response);
    }
}
