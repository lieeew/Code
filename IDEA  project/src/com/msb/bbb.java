package com.msb;

import java.util.Arrays;

public class bbb {
    public static void main (String[] arges) {
        int [] arr1 = {12,19,56,49,66,10,20};
        int [] arr2 = {10,50,80,60,444,666};
        System.arraycopy(arr1,2,arr2,0,3);
        System.out.println(Arrays.toString(arr2));
    }
}
