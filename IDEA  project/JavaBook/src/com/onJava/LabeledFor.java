package com.onJava;

/**
 * @Author: qxy
 * @Date: 2023/2/27
 * @Description:
 */
public class LabeledFor {
    public static void main(String[] args) {
        int i = 0;
        outor:
        for (; true; ) {
            innr:
            for (; i < 10; i++) {
                System.out.println("i = " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue ;
                }
                if (i == 3) {
                    System.out.println("break");
                    i++;
                    break;
                }
                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    continue outor;
                }
                if (i == 8) {
                    System.out.println("break outer");
                    break outor;
                }
                for (int k = 0; k < 5; k++) {
                    if (k == 3) {
                        System.out.println("continue inner");
                        continue innr;
                    }
                }
            }
        }
    }
}
