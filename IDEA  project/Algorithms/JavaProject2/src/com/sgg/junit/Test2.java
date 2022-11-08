package com.sgg.junit;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/2 - 11 - 02
 * @Description: com.sgg.junit
 */
public class Test2 {

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        for (int i = 3; i < arr.length - 1; i++) {
//            arr[i] = arr[i + 1];
//        }
        for (int i = 4; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = 0;
        System.out.println(Arrays.toString(arr));
    }
}
