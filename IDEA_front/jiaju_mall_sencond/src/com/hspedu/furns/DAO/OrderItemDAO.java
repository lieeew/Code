package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.OrderItem;

import java.util.ArrayList;

/**
 * ClassName: OrderItemDAO
 * Package: com.hspedu.furns.DAO
 *
 * @Author: leikooo
 * @Creat: 2023/5/7 - 16:51
 * @Description:
 */
public interface OrderItemDAO {

    int addOrderItem(OrderItem orderItem);
    int getTotalCount(String orderId);
    ArrayList<OrderItem> getOrderItems(String orderId);
}
