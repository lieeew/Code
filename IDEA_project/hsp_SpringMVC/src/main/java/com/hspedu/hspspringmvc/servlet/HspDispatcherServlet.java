package com.hspedu.hspspringmvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: HspDispatcherServlet
 * Package: com.hspedu.hspspringmvc.servlet
 *
 * @Author: leikooo
 * @Creat: 2023/6/12 - 6:02
 * @Description: 前端控制器, 充当原生的 Servlet , 所以需要继承 HttpServlet
 */
public class HspDispatcherServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OK-HspDispatcherServlet doPost() 被调用~");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OK-HspDispatcherServlet doGet() 被调用~");

    }
}
