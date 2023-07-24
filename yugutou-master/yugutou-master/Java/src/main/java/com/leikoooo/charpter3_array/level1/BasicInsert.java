package com.leikoooo.charpter3_array.level1;

import org.junit.jupiter.api.Test;

/**
 * @author leikooo
 * @create 2023-07-24 11:50
 * @Package com.leikoooo.charpter3_array.level1
 * @Description
 */
public class BasicInsert {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 9, 10};
        int i = addByElementSequence(arr, 5, 0);
        System.out.println(i);
    }

    /**
     * 插入元素
     *
     * @param arr     数组
     * @param size    数组已经存储的元素数量，从1开始编号，实际存储的有效值
     * @param element 待插入的元素
     * @return
     */
    public static int addByElementSequence(int[] arr, int size, int element) {
        // 最后一个就是 size == arr.length
        if (size >= arr.length) {
            return -1;
        }

        int index = size;

        for (int i = 0; i < size; i++) {
            if (element < arr[i]) {
                index = i;
                break;
            }
        }

        // 元素后移
        for (int i = size; i > index ; i--) {
            arr[i] = arr[i - 1];
        }

        // 插入数据
        arr[index] = element;

        return index;
    }

    /**
     * 插入元素
     *
     * @param arr     数组
     * @param size    数组已经存储的元素数量，从 1 开始编号，实际存储的有效值
     * @param element 待插入的元素
     * @return
     */
    public static int addByElementSequence2(int[] arr, int size, int element) {
        if (size >= arr.length) {
            return -1;
        }

        int index = size;

        for (int i = 0; i < size; i++) {
            if (element < arr[i]) {
                index = i;
                break;
            }
        }
        // 交换
        for (int j = size; j > index; j--) {
            arr[j] = arr[j - 1];
        }

        arr[index] = element;

        return index;
    }
}
