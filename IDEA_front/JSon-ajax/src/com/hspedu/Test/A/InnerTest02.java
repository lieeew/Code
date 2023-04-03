package com.hspedu.Test.A;

/**
 * @Author: qxy
 * @Date: 2023/4/3
 * @Description:
 */
public class InnerTest02 {
    public static void main(String[] args) {
        OuterTest02 outerTest02 = new OuterTest02();
        System.out.println("hashCode:" + outerTest02);
        outerTest02.m2();

    }
}

class OuterTest02 {
    private int i = 10;

    private void m1() {
        System.out.println("m1()~~");
    }

    public void m2() {

        final class Inner { // 一帮定义在方法中
            private int i = 20;
            public void f1() {
                // 局部内部类可以直接访问外部类的成员
                System.out.println("i = " + OuterTest02.this.i);
                // 由于规则是就近原则, 想要调用外部代码块的同名属性
                System.out.println("hashcode = " + OuterTest02.this);
                m1();
            }
        }
        // 外面可以通过创建对象的方式使用内部类的方法
        new Inner().f1();
    }
}
