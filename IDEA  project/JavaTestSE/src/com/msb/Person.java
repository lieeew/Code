package com.msb;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/29 - 07 - 29
 * @Description: com.msb
 */
public class Person {
    // 名词 -->> 属性
    int age; // 年龄
    String name;  // 成员变量
    double height;// 成员变量
    double weight;// 成员变量

    public void eat () {
        System.out.println("我喜欢吃饭");
        int num = 1; // 局部变量 必须有初始值
    }
    public void sleep (String adress) {
        System.out.println("我在" + adress + "睡觉");
    }
    public String introduce () {
        return "我的名字" + name + "\n我的体重" + weight + "\n我的身高" + height;
    }

}
