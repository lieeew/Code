package com.yugutou.charpter12_string.level2;

import java.util.Arrays;

public class CheckPermutation {
    public static void main(String[] args) {
        String s1 = "abcadfhg", s2 = "bcafdagh";
        System.out.println(checkPermutation(s1, s2));
    }

    public static boolean checkPermutation(String s1, String s2) {
        // 将字符串转换成字符数组
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        // 对字符数组进行排序
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        // 再将字符数组转换成字符串，比较是否相等
        return new String(s1Chars).equals(new String(s2Chars));
    }
}

