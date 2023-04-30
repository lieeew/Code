package com.hspedu.furns.DAO.impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.OrderItemDAO;
import com.hspedu.furns.entity.OrderItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @Author: qxy
 * @Date: 2023/4/26
 * @Description:
 */
public class OrderItemDAOImpl extends BasicDAO<OrderItem> implements OrderItemDAO {

    @Override
    public int saveOrderItem(@NotNull OrderItem orderItem) {
        // 写代码不要着急要小心
        return update("INSERT INTO orderitems (`id`, `name`, `price`, `count`, `total_price` , `order_id`) VALUES(?, ?, ?, ?, ?, ?)",
                 orderItem.getId(), orderItem.getName(), orderItem.getPrice(), orderItem.getCount(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    /**
     * 获取对应用户的账单总数
     * @param orderId 订单号码
     * @return 账单总数
     */
    @Override
    public int getTotalCount(String orderId) {
        String sql = "SELECT sum(count) FROM orderitems WHERE order_id = ?";
        return ((Number)queryScalar(sql, orderId)).intValue();
    }

    @Override
    public ArrayList<OrderItem> getOrderItems(String orderId) {
        String sql = "SELECT `id`, `name`, `price`, `count`, `total_price` AS `totalPrice`, `order_id` AS `orderId` FROM orderitems WHERE `order_id` = ?";
        return (ArrayList<OrderItem>) queryMulti(sql, OrderItem.class, orderId);
    }

    @Override
    public int getTotalCountPrice(String orderId) {
        String sql = "SELECT sum(total_price) FROM orderitems WHERE order_id = ?";
        return ((Number)queryScalar(sql, orderId)).intValue();
    }
}
