package com.hsp.servletConfig;

/**
 * @Author: qxy
 * @Date: 2023/2/21
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class servletConfig extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        /*
        在DBServlet 执行 doGet()/doPost() 时，可以获取到web.xml配置的用户名和密码
        你是一个OOP程序员->现有的方法或对象来搞定
        DBServlet的父类GenericServlet有getServletConfig()
        老韩解读
        1. getServletConfig() 方法是 GenericServlet下面的
        2. 返回的 servletConfig对象是 GenericServlet private transient ServletConfig config;
        3. 当一个属性被 transient 修饰，表示该属性不会被串行化(有些重要信息，不希望保存到文件)

        */

        System.out.println("初始化参数username = " + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数pwd = " + servletConfig.getInitParameter("pwd"));
        System.out.println("servletConfig" + servletConfig);
    }

    /*

       老师梳理ServletConfig config 使用流程
       1. 当DBServlet对象初始化时, tomcat会同时创建一个 ServletConfig对象
       2. 这时如果DBServlet init() 方法中你调用 super.init(config);
       3. 调用 父类 GenericServlet
       public void init(ServletConfig config) throws ServletException {
           this.config = config;
           this.init();
       }
       这时就会把 Tomcat创建的 ServletConfig对象赋给 GenericServlet的属性 config
       4. 因此如果你重写init()方法，记住如果你想在其它方法通过 getServletConfig() 方法获取ServletConfig
       , 则一定要记住 调用  super.init(config);

 */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init = " + config);
    }
}
