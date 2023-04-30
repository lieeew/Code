package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.OrderItem;

import java.util.ArrayList;

/**
 * @Author: qxy
 * @Date: 2023/4/26
 * @Description:
 */
public interface OrderItemDAO {

    /**
     * 将传入的OrderItem对象保存到数据库中
     * @param orderItem
     * @return
     */
    int saveOrderItem(OrderItem orderItem);

    int getTotalCount(String orderId);

    ArrayList<OrderItem> getOrderItems(String orderId);

    int getTotalCountPrice(String orderId);
}
