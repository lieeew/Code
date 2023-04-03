package com.hspedu.Test.A;

/**
 * @Author: qxy
 * @Date: 2023/4/3
 * @Description:
 */
public class InnerTest { //外部类
    public static void main(String[] args) {


    }
}

class Outer { // 外部类
    private int i = 10;

    public Outer() {
        System.out.println("outer构造器~~");
    }
    public void m1() {
        System.out.println("m1() 方法~~~~");
    }

    {
        System.out.println("代码块~~");
    }

    class Inner { // 内部类

    }
}

