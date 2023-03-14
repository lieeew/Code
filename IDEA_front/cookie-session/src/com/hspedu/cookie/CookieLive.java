package com.hspedu.cookie;

/**
 * @Author: qxy
 * @Date: 2023/3/10
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

@WebServlet(name = "CookieLive", urlPatterns = "/CookieLive")
public class CookieLive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CookieLive 被调用~~~");

        Cookie cookie = new Cookie("job", "java");
        /*
        1. 从创建cookie开始计时, 60s后无效
        2. 浏览器来根据创建的时间, 计时60s, 就认为该cookie无效
        3. 如果该cookie无效, 那么浏览器在发出http请求时. 就会回写携带该cookie
         */
        cookie.setMaxAge(60); // 60s
        response.addCookie(cookie);

        // 销毁某一个cookie
        Cookie username = CookieUtils.readCookieByName("username", request.getCookies());
        if (username == null) {
            System.out.println("没有找到该cookie");
        } else {
            // 将其生命周期设置为0 就等价于删除该cookie, 该cookie会被浏览器直接删除
            // 相关的http响应 : Set-Cookie: username=hsp; Expires=Thu, 01-Jan-1970 00:00:10 GMT
            username.setMaxAge(0);
            response.addCookie(username); // 必须要执行这个炒操作才行
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>设置cookie声明周期成功~~~</h1>");
        writer.flush();
        writer.close();
    }
}
