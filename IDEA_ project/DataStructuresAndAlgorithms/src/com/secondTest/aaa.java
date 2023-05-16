package com.secondTest;

/**
 * @Author: qxy
 * @Date: 2023/2/5
 * @Description:
 */

public class aaa {
    static {
        int x = 5;
    }

    static int x, y;

    public static void main(String args[]) {
//        x--;
//        myMethod();
//        System.out.println(x + y + ++x);
//        x = 1;
//        y = x++;
//        System.out.println("x " + x + " y " + y);
//        int x = 0;
//        int y = ++x + x++ + x++;
//        System.out.println("y = " + y);
//        System.out.println("x = " + x);

        int a=13;
        a=a/5;
        System.out.println(a);
    }

    public static void myMethod() {
        y = x++ + ++x;
    }
    /*
    x = 1;
    y = ++x;

    //x的值先增加
    结果：x=2，y=2

    x = 1;
    y = x++;
    // x的值向计算后增加
    // x = 2 y = 1
     */
}