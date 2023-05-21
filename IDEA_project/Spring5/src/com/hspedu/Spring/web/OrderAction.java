package com.hspedu.Spring.web;

import com.hspedu.Spring.Service.OrderService;

/**
 * ClassName: OrderAction
 * Package: com.hspedu.Spring.web
 *
 * @Author: leikooo
 * @Creat: 2023/5/21 - 7:47
 * @Description: 就是Servlet或者是Controller
 * 在 Java Web 开发中，Controller 是 MVC（Model-View-Controller）设计模式中的一部分。
 * Controller 一般用于处理 Web 请求并将请求路由到相应的处理程序方法中
 */
public class OrderAction {
    public OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
