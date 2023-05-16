package com.onJava.appand;

import org.junit.Test;

/**
 * @Author: qxy
 * @Date: 2023/2/27
 * @Description:
 */
public class appandTest {

    public int m1() {
        int i = 10;
        return ++i;
    }

    @Test
    public void test1() {
        System.out.println("m1() = " + m1());
    }
}
