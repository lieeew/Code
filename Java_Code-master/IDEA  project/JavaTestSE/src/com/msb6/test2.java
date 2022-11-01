package com.msb6;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/1 - 08 - 01
 * @Description: com.msb6
 */
public class test2 {
    // 属性
    int age;
    static int sid = 10;
    {
        System.out.println("------------b");
    }
    // 空构造器
    public test2 () {
        System.out.println("这个空构造器");

    }
    // 有参构造器
    public test2 (int a) {
        System.out.println("这是有参构造器");
        age = a;
    }
    // 方法
    public void eat () {
        System.out.println(sid);
        System.out.println(age);
        System.out.println("这是一个方法");
    }
    public static void play () {

        System.out.println(sid);
        System.out.println("这是一个静态的方法");
    }

    public static void main(String[] args) {
        test2 t = new test2 (10);
        System.out.println(t.age);
        t.eat();
        t.play();
    }
}
