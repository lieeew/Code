package com.msb.Test09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/5 - 08 - 05
 * @Description: com.msb.Test09
 */
public class Student extends Person {
    int age = 777;
    public void eat () {
        System.out.println("哦里给");
    }
    public void a () {
        eat();
        super.eat();
        System.out.println(super.age);
        System.out.println(this.age);
    }
}
