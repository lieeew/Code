package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.Impl.OrderDAOImpl;
import com.hspedu.furns.DAO.Impl.OrderItemDAOImpl;
import com.hspedu.furns.DAO.OrderDAO;
import com.hspedu.furns.DAO.OrderItemDAO;
import com.hspedu.furns.entity.*;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * ClassName: OrderServiceImpl
 * Package: com.hspedu.furns.service.impl
 *
 * @Author: leikooo
 * @Creat: 2023/5/8 - 15:04
 * @Description:
 */
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private final FurnService furnService = new FurnServiceImpl();

    @Override
    public String saveOrder(Cart cart, Integer memberId) {
        String id = System.currentTimeMillis() + "_" + memberId;
        // 创建order对象
        Order order = new Order(id, new Date(), cart.getTotalPrice(), 0, memberId);
        orderDAO.addOrder(order);
        // 创建orderItems对象
        Map<Integer, CartItem> items = cart.getItems();
        for (CartItem cartItem : items.values()) {
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getPrice(), cartItem.getCount(), cartItem.getTotalPrice(), id);
            // 添加到DB
            orderItemDAO.addOrderItem(orderItem);
            // 修改furn表单
            Furn furn = furnService.getFurnById(cartItem.getId());
            // 销量要增加, 库存要减少
            furn.setSales(furn.getSales() + cartItem.getCount());
            furn.setStock(furn.getStock() - cartItem.getCount());
            furnService.updateFurn(furn);
        }
        return id;
    }

    @Override
    public int getTotalCount(String id) {
        return orderItemDAO.getTotalCount(id);
    }

    @Override
    public ArrayList<OrderItem> getOrderItems(String id) {
        return orderItemDAO.getOrderItems(id);
    }

    @Override
    public Order getOrder(String id) {
        return orderDAO.getOrder(id);
    }
}
