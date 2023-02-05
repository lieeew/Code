package com.Algorithms;


/**
 * @Author: qxy
 * @Date: 2023/2/5 10
 * @Description:
 */
public class class03_sort {

    /**
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) { // 先想边界条件, 如果arr == null 后面的条件才判断
            return;
        }
        // 0 ~ n-1
        // 1 ~ n-1
        // 2 ~ n-1
        // 3 ~ n-1
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValuesIndex = i; // 假设最小索引在i位置
            for (int j = i + 1; j < N; j++) {
                minValuesIndex = arr[j] < arr[minValuesIndex] ? j : minValuesIndex; // 早出最小位置的索引
            }
            swap(arr, i, minValuesIndex); // i位置与最小索引位置的值进行交换
        }
    }

    /**
     * 冒泡排序
     * 先想好例子, 在做抽象话
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) { // 先想边界条件, 如果arr == null 后面的条件才判断
            return;
        }
        // 0 ~ n-1
        // 0 ~ n-2
        // 0 ~ n-3
        // 0 ~ n-4
        // 0 ~ end
        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            // 干一坨事
            // 0 - 1   1 - 2    2 - 3    3 - 4    n- 1 - n
            for (int i = 0; i < end; i++) {// 相当于第一个看成变量
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) { // 先想边界条件, 如果arr == null 后面的条件才判断
            return;
        }
        // 0 ~ 0 ok
        // 0 ~ 1
        // 0 ~ 2
        // 0 ~ 3
        // 0 ~ 4
        // 0 ~ 5
        // 0 ~ N -1
        int N = arr.length;
        for (int num = 1; num < N; num++) {
            int newInsertIndex = num;
            while (newInsertIndex - 1 >= 0 && arr[newInsertIndex - 1] > arr[newInsertIndex]) {
                swap(arr, newInsertIndex, newInsertIndex - 1);
                newInsertIndex--;
                // 退出的条件已经包含
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {31, 5, 21, 8, 20, 1, 0, 3, 90, 39, 29};
        printArr(arr);
        insertSort1(arr);
        printArr(arr);
    }
}
