package com.hspedu.Test.A;

/**
 * @Author: qxy
 * @Date: 2023/4/3
 * @Description:
 */
public class InnerClassExercise02 {
    public static void main(String[] args) {

        // 匿名内部类当成实参传递
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("show");
            }
        });

        f1(new Picture());
    }

    // 形参是接口类型
    public static void f1(IL il) {
        il.show();
    }
}

interface IL {
    void show();
}

// 这种方式属于硬编码, 不推荐
class Picture implements IL {
    @Override
    public void show() {
        System.out.println("这是一幅画~~");
    }
}