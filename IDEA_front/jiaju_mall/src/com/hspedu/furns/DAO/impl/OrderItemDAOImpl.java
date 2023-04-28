package com.hspedu.furns.DAO.impl;

import com.hspedu.furns.DAO.BasicDAO;
import com.hspedu.furns.DAO.OrderItemDAO;
import com.hspedu.furns.entity.OrderItem;
import org.jetbrains.annotations.NotNull;

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
}
