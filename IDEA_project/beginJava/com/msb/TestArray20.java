package com.msb;
public class TestArray20 {
    public static void main (String[] arsgw) {
//        int[] arr2 = new int [] {1,6,4};
//        System.out.println(Arrays.toString(arr2));
        int[] [] arr = new int[3] [];
        // 一维数组长度为3
        int [] arr1 = {1,2,3};
        arr [0] = arr1;
        arr [1] = new int[] {10,50,666};
        arr [2] = new int [] {10,888};
        // 对二维数组进行遍历
        // 外层普通 + 内层普通
//        for (int a = 0; a < arr.length;a++) {
//            for (int b = 0; b < arr[a].length;b++) {
//                System.out.print(arr [a] [b] + "\t");
//            }
//        }
        // 外层普通 + 内层增强for
//        for (int a = 0; a < arr.length;a++) {
//            for (int num:arr[a]) {
//                System.out.print(num + "\t");
//        }
//            System.out.println();
//        }
        // // 外层增强for + 内层增强for
//        for (int[] a:arr) {
//            for (int num:a) {
//                System.out.println(num);
//            }
//        }
//
        // // 外层增强for + 内层普通for
//        for (int[] a : arr ) {
//            for (int b = 0;b < a.length;b++) {
//                System.out.print(a[b] + "\t");
//            }
//        }
//
    }
}
