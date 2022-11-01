package com.atguigu.service;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/5 - 10 - 05
 * @Description: com.atguigu.service
 */
public class Status {
    private String name;

    public Status() {
    }

    public Status(String name) {
        this.name = name;
    }

    public static final Status FREE = new Status();
    public  static final Status BUSY = new Status();
    public static final Status VACATION = new Status();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
