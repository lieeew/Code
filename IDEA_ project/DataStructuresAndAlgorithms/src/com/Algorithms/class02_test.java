package com.Algorithms;


import java.sql.ResultSet;

/**
 * @Author: qxy
 * @Date: 2023/2/5 10
 * @Description: 阶乘
 */
public class class02_test {
    public int sum(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int k = k(i);
            sum += k;
        }
        return sum;
    }

    public int k(int a) {
        int sum = 1;
        for (int i = 1; i <= a; i++) {
            sum *= i;
        }
        return sum;
    }

    public void test1() {
        System.out.println("sum = " + sum(10));
        System.out.println("sum = " + betterAdd(10));
    }

    /**
     * 優化這個思路
     */
    public int betterAdd(int N) {
        int sum = 0;
        int variable = 1;
        for (int i = 1; i <= N; i++) {
           variable *= i; // 把上一个的阶乘结果拿来使用
           sum += variable;
        }
        return sum;
    }
}
