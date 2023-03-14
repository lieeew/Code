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

@WebServlet(name = "ReadSession2", urlPatterns = "/ReadSession2")
public class ReadSession2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReadSession2 ~~~~~");
        HttpSession session = request.getSession();
        System.out.println("sessionId = " + session.getId());

        Object email = session.getAttribute("email");
        if (email != null) {
            System.out.println("读取到了 email = " + (String) email);
        } else {
            System.out.println("没有读取到~~~~");
        }
    }
}
