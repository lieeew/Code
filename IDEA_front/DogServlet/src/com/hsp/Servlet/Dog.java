package com.hsp.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: qxy
 * @Date: 2023/2/18
 * @Description:
 */
public class Dog extends HttpServlet {
    private int get_num = 1;
    private int post_num = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("第" + get_num++ + "次调用 doGet方法~~~");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("第" + post_num++ + "次调用 doPost方法~~~~");
    }

}
