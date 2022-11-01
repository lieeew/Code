package com.msb4;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/30 - 07 - 30
 * @Description: com.msb4
 */
public class Test {
    public static void main(String[] args) {
        // 具体的对象
        Person p = new Person ("lili",16,16.9);
        System.out.println(p.name);
        System.out.println(p.age);
        p.eat();
        p.play();
    }
}
