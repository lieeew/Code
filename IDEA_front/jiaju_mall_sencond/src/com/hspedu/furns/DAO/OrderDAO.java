package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.Order;

/**
 * ClassName: OrderDAO
 * Package: com.hspedu.furns.DAO
 *
 * @Author: leikooo
 * @Creat: 2023/5/7 - 14:57
 * @Description:
 */
public interface OrderDAO {

    int addOrder(Order order);
    Order getOrder(String id);
}
