package com.msb;

import java.util.Arrays;

public class TestArray19 {
    public static void main (String[] arges) {
        int [] arr1 = {1,56,99,21,22,33,66,99};
        int [] arr2 = {15,95,261,6,1,95,999};
        System.arraycopy(arr1,2,arr2,2,3);
        System.out.println(Arrays.toString(arr2));
    }
}
