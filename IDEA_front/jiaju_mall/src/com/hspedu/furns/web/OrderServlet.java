package com.hspedu.furns.web;

/**
 * @Author: qxy
 * @Date: 2023/4/28
 * @Description:
 */

import com.hspedu.furns.DAO.OrderItemDAO;
import com.hspedu.furns.DAO.impl.OrderItemDAOImpl;
import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.entity.OrderItem;
import com.hspedu.furns.service.OrderService;
import com.hspedu.furns.service.impl.OrderServiceImpl;
import com.hspedu.furns.utils.JDBCUtilsByDruid;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends BasicServlet {
    private OrderService orderService = new OrderServiceImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    /**
     * 生成订单
     */
    protected void saveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 业务代码
        // todo
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getItems().size() == 0) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return; // 返回
        }
        if (member == null) {
            response.sendRedirect(request.getContextPath() + "/views/member/login.jsp");
            return;
        }
        // String orderId = null;
        // ArrayList<OrderItem> orderItems = null;
        // int totalCount = 0;
        // int totalCountPrice = 0;
        // 事务控制
        // try {
        //     orderId = orderService.saveOrder(cart, member.getId());
        //     totalCount = orderItemDAO.getTotalCount(orderId);
        //     totalCountPrice = orderItemDAO.getTotalCountPrice(orderId);
        //     orderItems = orderItemDAO.getOrderItems(orderId);
        //     // 没有问题就提交
        //     JDBCUtilsByDruid.commit();
        // } catch (Exception e) {
        //     // 出现异常就回滚
        //     ((Cart)request.getSession().getAttribute("cart")).clearAllCartItems();
        //     JDBCUtilsByDruid.rollBack();
        // }
        String orderId = orderService.saveOrder(cart, member.getId());
        int totalCountPrice = orderItemDAO.getTotalCountPrice(orderId);
        ArrayList<OrderItem> orderItems = orderItemDAO.getOrderItems(orderId);
        int totalCount = orderItemDAO.getTotalCount(orderId);
        // 便于前端读取数据
        session.setAttribute("orderId", orderId);
        session.setAttribute("orderItems", orderItems);
        session.setAttribute("totalCount", totalCount);
        session.setAttribute("totalPrice", totalCountPrice);
        // 使用重定向找到 checkout.jsp
        response.sendRedirect(request.getContextPath() + "/views/order/checkout.jsp");

    }
}
