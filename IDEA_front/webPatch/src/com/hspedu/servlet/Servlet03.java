package com.hspedu.servlet;

/**
 * @Author: qxy
 * @Date: 2023/3/7
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet03", urlPatterns = "/servlet03")
public class Servlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 这里我们使用转发(只发生在服务器端)定位到 b.html
        // 老韩解读
        // 1. 在服务器端解析第一个/ 会被解析为 http://ip:port/项目名
        // 这个项目其实就是 : Application Context
        // 2. "/d1/d2/b.html" ==> 会被解析为 http://ip:port/项目名/d1/d2/b.html
        System.out.println("servlet03 会进行转发~~~");
        request.getRequestDispatcher("/d1/d2/b.html").forward(request, response);

        // 3. 在服务器进行转发时, 发现没有/ 就按照默认的方式参考定位 http://ip:port/项目表
        // 建议使用上面的
        request.getRequestDispatcher("d1/d2/b.html").forward(request, response);
    }
}
