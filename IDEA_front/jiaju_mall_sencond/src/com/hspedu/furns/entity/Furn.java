package com.hspedu.furns.entity;

import java.math.BigDecimal;

/**
 * @Author: qxy
 * @Date: 2023/5/5
 * @Description:
 */
public class Furn {

    private Integer id; // 尽量用包装类
    private String name;
    private String maker;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String imgPath = "assets/images/product-image/8.jpg";

    public Furn(Integer id, String name, String maker, BigDecimal price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        if (imgPath != null) {
            this.imgPath = imgPath;
        }
    }

    public Furn() {
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

    public void setImgPath(String imgPatch) {
        this.imgPath = imgPatch;
    }

    @Override
    public String toString() {
        return "Furn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", price='" + price + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPatch='" + imgPath + '\'' +
                '}';
    }
}
