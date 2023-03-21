package com.hspedu.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: qxy
 * @Date: 2023/3/21
 * @Description:
 */

/*
1. 当一个类实现了 ServletContextListener
2. 那么该类就是一个监听器
3. 该类可以监听的事件, 由该类实现的监听接口决定
4. HspServletContextListener 就是一个监听者
5. 当web应用启动时, 就会产生ServletContextEvent事件, 就会调用监听器对应的事件处理方法contextInitialized, 同时会传递数据对象
6. 程序员可以通过 ServletContextEvent 事件对象, 用于获取需要的信息, 记性业务处理
7. tomcat怎么知道有这监听器 ? 因为我们会在web.xml里面配置
 */
public class HspServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听到 " + servletContextEvent.getServletContext() + "被创建~~~");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("检测到 " + servletContextEvent.getServletContext() + "被销毁~~~~~~~~~~~~ ");

        // 可以对servletContextEvent 数据进行处理, 记性日志处理
    }
}
