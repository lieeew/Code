package com.msb5;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/31 - 07 - 31
 * @Description: com.msb5
 */
public class emo {
    int id;
    static int sid = 666;
    int age;
    double weight;
    String name;
    public emo () {

    }
    public emo (int age, double weight, String name) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }
    // 方法
    public void eat () {
        System.out.println("我喜欢干饭");
    }
    public static void play () {
        System.out.println(sid);
    }
    // 程序入口
    public static void main(String[] args) {
        emo e = new emo (10,16.7,"lili");
        System.out.println(e.age);
        emo.play();
    }
}
