package com.hspedu.cookie;

/**
 * @Author: qxy
 * @Date: 2023/3/9
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReadCookieByNameServlet", urlPatterns = "/RCookieByName")
public class ReadCookieByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReadCookieByNameServlet 被调用了~~~");
        Cookie username = CookieUtils.readCookieByName("xxx", request.getCookies());
        if (username == null) {
            System.out.println("sorry, 没有查询到这个cookie信息~~~");
        } else {
            System.out.println("username = " + username.getValue());
        }
    }
}
