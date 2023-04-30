package com.hspedu.furns.service.impl;

import com.hspedu.furns.DAO.FurnDAO;
import com.hspedu.furns.DAO.OrderDAO;
import com.hspedu.furns.DAO.OrderItemDAO;
import com.hspedu.furns.DAO.impl.FurnDAOImpl;
import com.hspedu.furns.DAO.impl.OrderDAOImpl;
import com.hspedu.furns.DAO.impl.OrderItemDAOImpl;
import com.hspedu.furns.entity.*;
import com.hspedu.furns.service.OrderService;
import java.util.*;

/**
 * @Author: qxy
 * @Date: 2023/4/27
 * @Description:
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private FurnDAO furnDAO = new FurnDAOImpl();

    @Override
    public String saveOrder(Cart cart, int memberId) {
        // 这里的事务比较复杂 ThreadLocal + mysql事务机制 + 过滤器
        // 把cart数据以order和orderItem形式保存到数据库中
        // 拿到购物信息数据数据
        try {
            HashMap<Integer, CartItem> items = cart.getItems();
            // 这个uuid表示当前的订单账号
            String orderId = System.currentTimeMillis() + "" + memberId;
            // 生成订单
            Order order = new Order(orderId, new Date(), cart.getTotalPrice(), Status.PREPARING_FOR_SHIPMENT, memberId);
            // 保存到order中
            orderDAO.saveOrder(order);
            /*
                map的第二种遍历方式
                for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
                // 操作
                }
             */
            for (CartItem item : items.values()) {
                // 生成订单详情项
                OrderItem orderItem = new OrderItem(null, item.getName(), item.getPrice(), item.getCount(), item.getTotalPrice(), orderId);
                // 保存到orderItem
                orderItemDAO.saveOrderItem(orderItem);
                // 修改furn表数据
                Furn furn = furnDAO.getFurnById(item.getId());
                if (furn.getStock() >= item.getCount()) { // 库存大于买的总数
                    // Furn furn = new Furn(item.getId(), item.getName(), furn.getMaker(),
                    //         furn.getPrice(), furn.getSales() + item.getCount(), furn.getStock() - item.getCount(), furn.getImgPath());
                    furn.setSales(furn.getSales() + item.getCount());
                    furn.setStock(furn.getStock() - item.getCount());
                    furnDAO.update(furn);
                    System.out.println("由于stock不足, 添加是失败~~");
                }
            }

            //清空购物车, 防止重复购买
            cart.clearAllCartItems();

            return orderId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
