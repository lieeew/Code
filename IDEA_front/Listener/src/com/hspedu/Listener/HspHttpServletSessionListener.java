package com.hspedu.Listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: qxy
 * @Date: 2023/3/21
 * @Description:
 */
public class HspHttpServletSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();

        System.out.println("HspHttpServletSessionListener 监听到 session 创建 = " + session.getId());

        System.out.println("检查到 用户 " + session.getId() + "登录成功~~~");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        HttpSession session = httpSessionEvent.getSession();
        System.out.println("HspHttpServletSessionListener 监听到 session 销毁(destroyed) = " + session.getId());

        System.out.println("检查到 用户 " + session.getId() + " quite 退出成功~~~");
    }
}
