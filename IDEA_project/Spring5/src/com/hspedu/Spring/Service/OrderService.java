package com.hspedu.Spring.Service;

import com.hspedu.Spring.DAO.OrderDAO;

/**
 * ClassName: OrderService
 * Package: com.hspedu.Spring.Service
 *
 * @Author: leikooo
 * @Creat: 2023/5/21 - 7:44
 * @Description:
 */
public class OrderService {

    private OrderDAO orderDAO;

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }
    public void setOrderDAO2(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
