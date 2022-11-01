package com.msb3;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/29 - 07 - 29
 * @Description: com.msb3
 */
public class Person {
    public Person () {

    }
    String name;
    int age;
    double weight;
    public Person (String name, int age,double weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }
    public void eat () {
        System.out.println("谁不喜欢干饭呢?");
    }
    public void sleep (String adress) {
        System.out.println( "在"+ adress + "早睡早起,身体好");
    }
}
