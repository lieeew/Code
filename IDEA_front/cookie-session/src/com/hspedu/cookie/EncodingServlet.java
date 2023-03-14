package com.hspedu.cookie;

/**
 * @Author: qxy
 * @Date: 2023/3/12
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "EncodingServlet", urlPatterns = "/encode")
public class EncodingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("encode 被调用~~~~");

        // 不能添加中文信息, 直接存放会报错 HTTP Status 500 - Control character in cookie value or attribute.
        // 解决方法, 使用URL编码格式 (向编码后解码)
        String encode = URLEncoder.encode("韩顺平教育", "utf-8");
        Cookie cookie = new Cookie("company", encode);

        response.addCookie(cookie);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>读取cookie信息成功~~~<h1>");
        writer.flush();
        writer.close();
    }
}
