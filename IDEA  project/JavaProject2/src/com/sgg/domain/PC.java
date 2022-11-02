package com.sgg.domain;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/1 - 11 - 01
 * @Description: com.sgg.domain
 */
public class PC implements Equipment{

    private String model;
    private String display;

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
