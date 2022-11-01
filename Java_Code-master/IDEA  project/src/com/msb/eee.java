package com.msb;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/29 - 07 - 29
 * @Description: com.msb
 */
public class eee {
    public eee () {

    }
    int age;
    double weight;
    String name;
    public eee (int age, double weight, String name) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    public static void main(String[] args) {
        eee p = new eee (16,160.5,"lili");
        System.out.println(p.age);
        System.out.println(p.name);
        System.out.println(p.weight);
    }
}
