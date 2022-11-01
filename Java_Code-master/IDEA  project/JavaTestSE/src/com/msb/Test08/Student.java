package com.msb.Test08;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/4 - 08 - 04
 * @Description: com.msb.Test08
 */
public class Student extends Person {
    int age = 30;
    public void play () {
        System.out.println("哦里给");
    }
    public void eat () {
        System.out.println("我简直喜欢空气");
    }
    public void a () {
        this.eat();
        super.eat();
        System.out.println(super.age);
        System.out.println(this.age);
    }
}
