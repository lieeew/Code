package com.hsp.CheckServlet;

/**
 * @Author: qxy
 * @Date: 2023/2/22
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/checkServletRequest")
public class checkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("checkServletRequest~~");
        request.setCharacterEncoding("utf-8"); // 设置之后不会乱码
        // 根据用户名来确定是什么身份
        String username = request.getParameter("username");
        // 注意 : 如果在同一个request对象(请求转发), 那么可以在不同的servlet中. 可以使用getParameter获取
        if ("tom".equals(username)) {
            request.setAttribute("role", "管理員");
        } else {
            request.setAttribute("role", "普通用戶");
        }
        System.out.println("CheckRequest = " + request);
        // 获取分发器 1. /manageServlet写的是需要转发的servlet的url
        //          2. / 会被解析为 http://localhost:8888/Servlet
        //          3. forward() 把当前的request和response传给下一个servlet
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/manageServlet");
        requestDispatcher.forward(request, response);

    }
}
