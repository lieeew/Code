package com.secondTest;

/**
 * @Author: qxy
 * @Date: 2023/2/5
 * @Description: 重复练习
 */
public class class03_sortTest {
    /**
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) { // 先考虑不能排序的情况
            return;
        }

        /*
        0 ~ n - 1
        1 ~ n - 1
        2 ~ n - 1
        3 ~ n - 1
        i ~ n - 1
         */
        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i; // 这里最小值就是在最左侧, 比如 i
            /*
                0 和其他所有进行比较
             */
            for (int j = i; j < arr.length; j++) {
                minValueIndex = arr[minValueIndex] > arr[j] ? j : minValueIndex;
            }
            swap(arr, minValueIndex, i);
        }

    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /*
            0 ~ n - 1
            0 ~ n - 2
            0 ~ n - 3
            0 ~ n - 4
            0 ~ n - 5
            0 ~ i

         */
        int N = arr.length;
        for (int i = N - 1; i > 0; i--) {
            // do something
            // 0 1  1 2  2 3  3 4  i - 1  i
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort01(int[] arr) {
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
            int newInsertIndex = i;
            while (newInsertIndex - 1 >= 0 && arr[newInsertIndex] < arr[newInsertIndex - 1]) {
                swap(arr, newInsertIndex, newInsertIndex - 1);
                newInsertIndex--; // 插入的位置向左移动
            }
        }
    }

    public static void insertSort02(int[] arr) {
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
            // 0 1 2 3 4 5 6 7 8 9
            // pre 是前面的变量
            for (int pre = i - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    /**
     * 打印结果
     */
    public static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    /**
     * 交换
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {31, 5, 21, 8, 20, 1, 0, 3, 90, 39, 29};
        printArr(arr);
        insertSort02(arr);
        printArr(arr);
    }

}
