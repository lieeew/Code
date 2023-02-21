package com.hsp.servletContext;

/**
 * @Author: qxy
 * @Date: 2023/2/21
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class servletContext_ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取web.xml的context-parameter
        ServletContext servletContext = this.getServletContext();

        // 获取website
        ServletContext website = servletContext.getContext("website");
        // 获取公司名称
        ServletContext company = servletContext.getContext("company");
        // 获取工程路径
        String contextPath = servletContext.getContextPath();
        // 获取真实路径, out目录
        // "/"表示项目发布后的真实路径
        String realPath = servletContext.getRealPath("/");

        System.out.println("website = " + website);
        System.out.println("company = " + company);
        System.out.println("contextPath = " + contextPath);
        System.out.println("realPath = " + realPath);
    }
}
