package com.hspedu.furns.web;

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.service.OrderService;
import com.hspedu.furns.service.impl.OrderServiceImpl;
import com.hspedu.furns.utils.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: OrderServlet
 * Package: com.hspedu.furns.web
 *
 * @Author: leikooo
 * @Creat: 2023/5/7 - 18:23
 * @Description:
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/orderServlet"})
public class OrderServlet extends BasicServlet {
    private final OrderService orderService = new OrderServiceImpl();

    protected void saveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 需要获取到相关的cart和cartItems的相关属性, 设置相关的对象order和orderItems
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        int memberId = DataUtils.parseInt(req.getParameter("memberId"), 0);
        if (cart == null || cart.getItems().size() == 0) {
            // 没有购物, 不用结算
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        // 订单号id
        String id = null;
        try {
            id = orderService.saveOrder(cart, memberId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 设置相关属性, 前端显示
        session.setAttribute("orderItem", orderService.getOrderItems(id));
        session.setAttribute("id", id);
        session.setAttribute("totalCount", orderService.getTotalCount(id));
        session.setAttribute("order", orderService.getOrder(id));
        // 删除购物车的内容
        cart = cart.clearAllItem(cart);
        // 重定向到指定页面
        resp.sendRedirect(req.getContextPath() + "/views/order/checkout.jsp");
    }
}
