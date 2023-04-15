package com.hspedu.furns.entity;

/**
 * @Author: qxy
 * @Date: 2023/4/15
 * @Description:
 */
public class Furns {
    private Integer id;
    private String img;
    private String furns_name;
    private String solder_name;
    private Integer furns_price;
    private Integer furns_sales;
    private Integer furns_inventory;

    public Furns() {
    }

    public Furns(Integer id, String img, String furns_name, String solder_name, Integer furns_price, Integer furns_sales, Integer furns_inventory) {
        this.id = id;
        this.img = img;
        this.furns_name = furns_name;
        this.solder_name = solder_name;
        this.furns_price = furns_price;
        this.furns_sales = furns_sales;
        this.furns_inventory = furns_inventory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFurns_name() {
        return furns_name;
    }

    public void setFurns_name(String furns_name) {
        this.furns_name = furns_name;
    }

    public String getSolder_name() {
        return solder_name;
    }

    public void setSolder_name(String solder_name) {
        this.solder_name = solder_name;
    }

    public Integer getFurns_price() {
        return furns_price;
    }

    public void setFurns_price(Integer furns_price) {
        this.furns_price = furns_price;
    }

    public Integer getFurns_sales() {
        return furns_sales;
    }

    public void setFurns_sales(Integer furns_sales) {
        this.furns_sales = furns_sales;
    }

    public Integer getFurns_inventory() {
        return furns_inventory;
    }

    public void setFurns_inventory(Integer furns_inventory) {
        this.furns_inventory = furns_inventory;
    }

    @Override
    public String toString() {
        return "Furns{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", furns_name='" + furns_name + '\'' +
                ", solder_name=" + solder_name +
                ", furns_price=" + furns_price +
                ", furns_sales=" + furns_sales +
                ", furns_inventory=" + furns_inventory +
                '}';
    }
}
