package com.hspedu.furns.service;

import com.hspedu.furns.entity.Cart;

/**
 * @Author: qxy
 * @Date: 2023/4/27
 * @Description:
 */
public interface OrderService {

    /**
     *  保存订单相关信息到数据库, 修改的表很多(3个)
     * @param cart 数据的来源, 一切数据都可以在这里面拿, 是通过web层传入的
     * @param MemberId 关联地会员id
     */
    String saveOrder(Cart cart, int MemberId);
}
