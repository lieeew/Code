package com.msb5;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/7/31 - 07 - 31
 * @Description: com.msb5
 */
public class Demo {// 类名
    // 属性
    int id = 10;
    static int sid = 20;
    // 空构造器
    public Demo () {

    }
    // 方法
    public void a () {
        System.out.println("--------------a");
        System.out.println(sid);
        System.out.println(id);

    }
    // 方法
    public static void b () {
        System.out.println("--------------b");
        System.out.println(sid);


    }

    // 这是程序的入口
    public static void main(String[] args) {
        Demo d = new Demo ();
        Demo.b();
        d.a();


    }


}
