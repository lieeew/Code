package com.sbgTest01.Arrays;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/5 - 08 - 05
 * @Description: com.sbgTest01.Arrays
 */
public class Test {
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (key < arr[middle]) {
                high = middle - 1;
            } else if (key > arr[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;

    }

    // 测试下：从一组数中找3，输出数组下标
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 9, 78, 90, 167};
        System.out.println("数组下标："+binarySearch(arr, 3));
    }

}
