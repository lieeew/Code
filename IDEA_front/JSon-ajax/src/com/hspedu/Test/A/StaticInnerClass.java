package com.hspedu.Test.A;

/**
 * @Author: qxy
 * @Date: 2023/4/3
 * @Description:
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        Outer5.f1();

        // 访问静态成员内部类
        // 1. 方式一
        // 因为静态内部类, 是可以通过类名直接访问(前提是需要满足访问权限)
        Outer5.Inner5 inner5 = new Outer5.Inner5();
        inner5.show();

        // 2. 方式二
        Outer5.Inner5 inner = Outer5.getInner();
        inner.show();

    }
}

class Outer5 {// 外部类

    private int m = 10;
    private static int n = 20;

    // Inner5就是静态内部类
    // 1. 放在外部类的成员位置
    // 2. 使用static修饰
    // 3. 作用域是 整个类体
    static class Inner5 {
        public void show() {
//            System.out.println(m);
            System.out.println(n);
        }
    }

    public static void f1() {
        Inner5 inner5 = new Inner5();
        inner5.show();
    }

    public static Inner5 getInner() {
        return new Inner5();
    }

}



