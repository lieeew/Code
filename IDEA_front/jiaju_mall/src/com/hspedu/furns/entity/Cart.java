package com.hspedu.furns.entity;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/24
 * @Description: 购物车, 数据模型
 */
public class Cart {

    // 定义属性
    private HashMap<Integer, CartItem> items = new HashMap<>();


    // 购物车的商品总数, 看成一个属性, 放到里面的原因是${totalCount} 调用的就是getTotalCount()方法
    public Integer getTotalCount() {
        // 遍历hashMap
        Integer totalCount = 0;
        for (CartItem cartItem : items.values()) {
            Integer count = cartItem.getCount();
            totalCount += count;
        }
        return totalCount;
    }

    /**
     * 添加家居
     */
    public void add(CartItem cartItem) {
        CartItem cart_item = items.get(cartItem.getId());
        if (cart_item != null) {
            // 订单列表里面有
            cart_item.setCount(cart_item.getCount() + 1); // 订单数加1
            cart_item.setTotalPrice(cart_item.getPrice().multiply(new BigDecimal(cart_item.getCount())));
        } else {
            // 订单列表里面没有直接添加
            items.put(cartItem.getId(), cartItem);
        }
    }

    /**
     * 获取订单相关数据会显示
     */
    public ArrayList<CartItem> getCartValues() {
        return new ArrayList<>(items.values());
    }

    public HashMap<Integer, CartItem> getItems() {
        return items;
    }

    /**
     * 获取总金额
     *
     * @return totalPrice 总金额
     */
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem cartItem : items.values()) {
            BigDecimal price = cartItem.getTotalPrice();
            // 一定不要忘了把add里面的值进行累加
            totalPrice = totalPrice.add(price); // 将每个CartItem的价格加到总价中
        }
        return totalPrice;
    }

    /**
     * 清空购物车
     */
    public void clearAllCartItems() {
        items.clear();
    }

    /**
     * 变化商品数量
     */
    public void updateCount(@NotNull CartItem cartItem, int newNum) {
        // 先更新数量, 在更像总价
        cartItem.setCount(newNum);
        // 修改总金额
        cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
    }

    public void deleteCartItem(@NotNull CartItem cartItem) {
        Integer id = cartItem.getId();
        // 移除
        items.remove(id);
    }


    @Override
    public String toString() {
        return "Cart{" + "items=" + items + '}';
    }
}
