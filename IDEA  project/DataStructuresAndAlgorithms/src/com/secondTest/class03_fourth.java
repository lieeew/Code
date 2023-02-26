package com.secondTest;

import java.util.logging.Level;

/**
 * @Author: qxy
 * @Date: 2023/2/26
 * @Description:
 */
public class class03_fourth {
    /**
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) { // 如果arr为空或者是arr的长度为0
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int MinNumIndex = i;
            /*
            0 - N-1
            1 - N-1
            2 - N-1
            3 - N-1
            ...
            */
            for (int j = i + 1; j < N; j++) {
                MinNumIndex = arr[MinNumIndex] > arr[j] ? j : MinNumIndex;
            }
            swap(arr, i, MinNumIndex);
        }
    }

    /**
     * 冒泡排序
     */
    public static void doubleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /*
        0 - N -1
        0 - N -2
        0 - N -3
        0 - N -4
        .....
         */
        int N = arr.length;
        for (int i = N - 1; i > 0; i--) {
            /*
                0 1  1 2  2 3  3 4  4 5  5  6  N-2 N-1
             */
            for (int j = 0; j < i; j++) {
                int newNum = i;
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j  + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
         /*
        插入排序
        0 ~ 0 ok
        0 ~ 1
        0 ~ 2
        0 ~ 3
        0 ~ 4
        0 ~ n - 1
         */
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            int newNum = i;
            while (newNum - 1 >= 0 && arr[newNum] > arr[newNum - 1]) {
                swap(arr, newNum, newNum - 1);
                newNum--;
            }
        }
    }

    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {31, 5, 21, 8, 20, 1, 0, 3, 90, 39, 29};
        print(arr);
//        selectSort(arr);
//        doubleSort(arr);
        insertSort(arr);
        print(arr);
    }
}
