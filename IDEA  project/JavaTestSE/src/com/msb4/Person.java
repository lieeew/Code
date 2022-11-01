package com.msb4;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/30 - 07 - 30
 * @Description: com.msb4
 */
public class Person {
    // 属性
    int age;
    double weight;
    String name;
    // 空构造器
    public Person () {

    }
    // 有参构造器
    public Person (String name,int age,double weight) {
        this (name,age);
        this.weight = weight;

    }

    public Person (String name,int age) {
        this (age);
        this.name = name;
    }
    public Person (int age) {

        this.age = age;
    }
    public void eat () {
        int age = 10;
        System.out.println(this.age);
        System.out.println("我喜欢吃饭");
    }
    // 方法
    public void play () {
        this.fuck();
        System.out.println("睡觉");
        System.out.println("冲浪");
    }
    // 方法
    public void fuck () {

        System.out.println("吃饭");
    }

}
