package com.hspedu.furns.DAO;

import com.hspedu.furns.entity.OrderItem;

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

}
