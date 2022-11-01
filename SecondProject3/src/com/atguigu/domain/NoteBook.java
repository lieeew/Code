package com.atguigu.domain;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/6 - 10 - 06
 * @Description: com.atguigu.domain
 */
public class NoteBook implements Equipment{
    private String model;
    private double price;

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
