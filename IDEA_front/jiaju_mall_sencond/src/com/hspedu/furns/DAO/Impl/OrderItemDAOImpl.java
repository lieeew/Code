package com.hspedu.furns.DAO.Impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.OrderItemDAO;
import com.hspedu.furns.entity.OrderItem;

import java.util.ArrayList;

/**
 * ClassName: OrderItemDAOImpl
 * Package: com.hspedu.furns.DAO.Impl
 *
 * @Author: leikooo
 * @Creat: 2023/5/7 - 18:13
 * @Description:
 */
public class OrderItemDAOImpl extends BasicDAO<OrderItem> implements OrderItemDAO {

    @Override
    public int addOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO `order_item`(`id`, `name`, `price`, `count`, `total_price`, `order_id`) VALUES (NULL, ?, ?, ?, ?, ?)";
        return update(sql, orderItem.getName(), orderItem.getPrice(), orderItem.getCount(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public int getTotalCount(String orderId) {
        return ((Number)queryScalar("select sum(count) from order_item where order_id = ?", orderId)).intValue();
    }

    @Override
    public ArrayList<OrderItem> getOrderItems(String orderId) {
        String sql = "select `id`, `name`, `price`, `count`, `count`, `total_price` AS `totalPrice`, `order_id` AS `orderId` from `order_item` where `order_id` = ?";
        return (ArrayList<OrderItem>) queryMulti(sql, OrderItem.class, orderId);
    }
}
