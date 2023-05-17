package com.msb3;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/29 - 07 - 29
 * @Description: com.msb3
 */
public class TesJava {
    public static void main(String[] args) {
        Person p = new Person("lili",17,13.5);
        System.out.println(p.name);
        System.out.println(p.age);
        System.out.println(p.weight);
        p.eat();
        p.sleep("家");


    }
}
