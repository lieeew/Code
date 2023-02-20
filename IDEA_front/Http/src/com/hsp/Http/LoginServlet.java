package com.hsp.Http;

/**
 * @Author: qxy
 * @Date: 2023/2/19
 * @Description: loginServlet
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doGet方法被调用~~~");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(" Get请求 <h1>登录成功</h1>");

        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost方法被调用");
        // 輸出一句話給瀏覽器
        // 1.通过response获取PrintWriter,可以给浏览器数据. 底层是Tomcat把数据封装到对应的回复流
        // 设置ContentType必须在getWriter前面
        /*
        老韩解读 : text/html;charset=utf-8
        (1) 给会送数据设置编码
        (2) text/html 这个是MIME即告诉浏览器返回的数据类型是text类型下的html数据类型[MIME类型 大类型/小类型]
        (3) charset=utf-8 数据的编码
         */
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(" Post请求  <h1> 登录成功~~</h1>");
        // 为了保险
        writer.flush(); // flush()将缓存的数据进行刷新
        writer.close(); // 关闭流, close()底层也调用了flush()
    }
}
