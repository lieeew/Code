package com.hspedu.Test.A;

import sun.applet.Main;

/**
 * @Author: qxy
 * @Date: 2023/4/3
 * @Description:
 */
public class MemberInnerClass01 {
    public static void main(String[] args) {

        Outer02 outer02 = new Outer02();
        outer02.f1();

        // 方式一 : 外部类调用成员内部类的方式
        Outer02.Inner02 inner02 = outer02.new Inner02();
        inner02.say();

        // 方式二 : 使用方法
        Outer02.Inner02 inner021 = outer02.getInner02();
        inner021.say();


    }
}

class Outer02 {
    private int n = 10;
    public String name = "张三";

    private void f2() {

    }

    // 1. 在成员位置定义类, 成员内部类
    // 2. 可以添加任意访问的修饰符 (public protected private, 默认) , 因为他的地位就是一个成员
    class Inner02 {
        private double sal = 99.8;
        public void say() {
            System.out.println("n = " + n + " name = " + name);
            f2();
        }
    }

    public void f1() {
        Inner02 inner02 = new Inner02();
        inner02.say();
        // 在同一个类中
        double sal = inner02.sal;

    }

    public Inner02 getInner02() {
        return new Inner02();
    }
}
