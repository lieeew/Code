package com.atguigu.domain;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/6 - 10 - 06
 * @Description: com.atguigu.domain
 */
public class PC implements Equipment{
    private String model; // 表示机器的型号

    private String display; // 表示显示器名称

    public PC(String model, String display) {
        this.display = display;
        this.model = model;
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
