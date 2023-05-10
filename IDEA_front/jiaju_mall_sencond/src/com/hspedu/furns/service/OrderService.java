package com.hspedu.furns.service;

import com.hspedu.furns.entity.Cart;
import com.hspedu.furns.entity.Order;
import com.hspedu.furns.entity.OrderItem;

import java.util.ArrayList;

/**
 * ClassName: OrderService
 * Package: com.hspedu.furns.service
 *
 * @Author: leikooo
 * @Creat: 2023/5/8 - 15:03
 * @Description:
 */
public interface OrderService {

    String saveOrder(Cart cart, Integer id);
    int getTotalCount(String id);
    ArrayList<OrderItem> getOrderItems(String id);
    Order getOrder(String id);
}
