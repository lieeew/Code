package com.hspedu.Listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: qxy
 * @Date: 2023/3/21
 * @Description:
 */
public class HspHttpRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequestListener 被销毁 ~~");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("ServletRequestListener被创建 ");
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println(" 访问的ip地址 = " + servletRequest.getRemoteAddr());
        System.out.println("访问的资源链接 = " + ((HttpServletRequest) servletRequest).getRequestURI());
    }
}
