package com.Algorithms;

/**
 * @Author: qxy
 * @Date: 2023/2/4 20
 * @Description: <<左移  和 打印int类型的二进制 和  负数的原理
 */
public class class01_int {
    /**
     * 打印二进制
     */
    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((num & 1 << i) == 0 ? "0" : "1"));
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int num = 1;
//        print(num);
//        print(-1);
//        System.out.println(1 & 0);
//        System.out.println(1 | 0);
//        System.out.println(1 ^ 1);
//        print(1);
//        print(~1);
//        print(1);
        int c = 10;
        int d = -c;
        d = ~c + 1;
        print(c);
        print(d);
        print(Integer.MIN_VALUE);
        print(Integer.MIN_VALUE >> 1);
        print(Integer.MIN_VALUE >>> 1);
    }

}
