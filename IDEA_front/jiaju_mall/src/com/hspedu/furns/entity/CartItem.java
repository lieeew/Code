package com.hspedu.furns.entity;

import java.math.BigDecimal;

/**
 * @Author: qxy
 * @Date: 2023/4/24
 * @Description: 表示购物车的一项就是某一个家居
 */
public class CartItem {

    // 定义属性 --> 需求
    private Integer id; // 家居id
    private String name; // 家居名字
    private BigDecimal price; // 家居价格
    private Integer count; // 家居数量
    private BigDecimal totalPrice; // 家居总金额
    private String imgPath; // 图片地值

    public CartItem() {
    }

    public CartItem(Integer id, String name, BigDecimal price, Integer count, BigDecimal totalPrice, String imgPath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.totalPrice = totalPrice;
        this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
