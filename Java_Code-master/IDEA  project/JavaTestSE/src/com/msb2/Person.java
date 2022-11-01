package com.msb2;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/29 - 07 - 29
 * @Description: com.msb2
 */
public class Person {
    public Person () {// 不建议赋值
        age = 16;
        weight = 170.4;
        height = 165.6;
        name = "lili";

    }
    int age;
    String name;
    double height;
    double weight;
    public void eat () {
        System.out.println("我喜欢吃饭");
    }
    public void sleep () {
        System.out.println("我喜欢睡觉");
    }

}
