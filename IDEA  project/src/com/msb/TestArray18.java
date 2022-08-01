package com.msb;

import java.util.Arrays;

public class TestArray18 {
    public static void main (String[] arges) {
//        int [] arr1 = {2,5,9,1,4,7,3};
//        Arrays.sort(arr1);
//        System.out.println(Arrays.toString(arr1));
//        int num1 = Arrays.binarySearch (arr1,5);
//        System.out.println(num1);
        int [] arr2 = {2,5,9,1,4,7,3};
 //       int [] arr3 = Arrays.copyOf (arr2,4);
        int [] arr3 = Arrays.copyOfRange(arr2,1,4);
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.equals(arr2,arr3));


    }
}
