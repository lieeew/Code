package com.hspedu.furns.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: qxy
 * @Date: 2023/5/6
 * @Description: 购物车
 */
public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    /**
     * 添加到购物车
     * @param furn 被加入购物车的商品
     * @param count 加入购物车的数量, 默认是一
     */
    public void addItem(Furn furn, Integer count) {
        // 两种情况
        CartItem cartItem = null;
        if (!items.containsKey(furn.getId())) {
            // 情况一 购物车里面没有这个商品
            cartItem = new CartItem(furn.getId(), furn.getName(), count, furn.getPrice(), new BigDecimal(count).multiply(furn.getPrice()), furn.getImgPath());
        } else {
            // 购物车里面有这个商品
            cartItem = items.get(furn.getId());
            cartItem.setCount(cartItem.getCount() + count);
            cartItem.setTotalPrice(new BigDecimal(cartItem.getCount()).multiply(cartItem.getPrice()));
        }
        items.put(furn.getId(), cartItem);
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public int getTotalCount() {
        int count = 0;
        for (CartItem cartItem : items.values()) {
            count += cartItem.getCount();
        }
        return count;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        for (CartItem cartItem : items.values()) {
            totalPrice = cartItem.getTotalPrice().add(totalPrice);
        }
        return totalPrice;
    }

    /**
     * 清空购物车
     * @return 返回修改后的cart对象
     */
    public Cart clearAllItem(Cart cart) {
        cart.getItems().clear();
        return cart;
    }

    /**
     * 更新商品数量
     */
    public Cart updateCount(Cart cart, int newNum, int id) {
        CartItem cartItem = cart.getItems().get(id);
        cartItem.setCount(newNum);
        cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(newNum)));
        return cart;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
