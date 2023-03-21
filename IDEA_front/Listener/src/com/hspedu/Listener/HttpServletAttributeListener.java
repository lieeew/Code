package com.hspedu.Listener;

import javax.servlet.Servlet;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @Author: qxy
 * @Date: 2023/3/21
 * @Description:
 */
public class HttpServletAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("检测到 添加属性 " + servletContextAttributeEvent.getName() + " == " + servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("检测到 添加删除属性 " + servletContextAttributeEvent.getName() + " == " + servletContextAttributeEvent.getValue());

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("检测到 添加修改属性 " + servletContextAttributeEvent.getName() + " == " + servletContextAttributeEvent.getValue());

    }
}
