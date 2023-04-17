package com.hspedu.furns.entity;

import java.math.BigDecimal;

/**
 * @Author: qxy
 * @Date: 2023/4/16
 * @Description: 这个是一个JavaBean
 */
public class Furn {
    private Integer id; // 用Integer 可以防止空指针
    private String name;
    private String maker;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    // 这里有一个坑
    // 表的字段是 img_path 而这里写的是imgPath
    // 解决方案 使用 别名
    private String imgPath = "assets/images/product-image/7.jpg";

    public Furn() {
    }

    public Furn(Integer id, String name, String maker, BigDecimal price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        if (!(imgPath == null || imgPath.equals(""))) {
            this.imgPath = imgPath;
        }
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

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Furn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img_path='" + imgPath + '\'' +
                '}';
    }
}
