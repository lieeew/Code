package com.onJava;

/**
 * @Author: qxy
 * @Date: 2023/2/27
 * @Description:
 */
public class continueTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i == 97) {
                break;
            }
            if (i % 9 != 0) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}
