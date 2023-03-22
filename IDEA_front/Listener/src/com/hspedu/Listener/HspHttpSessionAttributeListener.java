package com.hspedu.Listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @Author: qxy
 * @Date: 2023/3/21
 * @Description:
 */
public class HspHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HspHttpSessionAttributeListener 监听到添加属性 = " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HspHttpSessionAttributeListener 监听到了 删除一个属性 = " + httpSessionBindingEvent.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HspHttpSessionAttributeListener 监听到一个属性" + httpSessionBindingEvent.getName() + "被替换为" + httpSessionBindingEvent.getValue());
    }
}
