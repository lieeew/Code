package com.leikoooo.charpter3_array.过关挑战;

import java.util.ArrayList;
import java.util.List;


/**
 * @author leikoooo
 */
public class HomeWork {

    /**
     * 删除相同的元素
     *
     * @param array 数组
     */
//    public static int deleteSomeValues(int[] array) {
//        // 定义两个指针，一个是 slow 一个是需要存入到 list 中的指针位置
//        int slow = 0, valueIndex, fast;
//        // 定义一个存储有效值的集合
//        List<Integer> list = new ArrayList<>();
//
//        for (fast = 0; fast < array.length - 1; fast++) {
//            if (array[fast] != array[slow]) {
//                if ((fast - slow) > 1) {
//                    slow = fast;
//                    if (array[fast] != array[fast + 1]) {
//                        valueIndex = slow;
//                        list.add(array[valueIndex]);
//                    }
//                } else {
//                    valueIndex = slow;
//                    if (array[fast] != array[fast + 1]) {
//                        list.add(array[valueIndex]);
//                    }
//                    slow = fast;
//                }
//            }
//        }
//        if (array[fast - 1] != array[fast]) {
//            list.add(array[fast]);
//        }
//        // 把 list 中的数据直接取代 array 中的对应位置
//        for (int i = 0; i < list.size(); i++) {
//            array[i] = list.get(i);
//        }
//        return list.size();
//    }

    /**
     * GPT 也太牛了吧
     *
     * @param array 需要去重的数组
     * @return
     */
    public static int deleteSomeValues(int[] array) {
        int count = 1; // 当前元素出现的次数
        int index = 0; // 新数组的下标
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                count++; // 相邻元素相等，次数加1
            } else {
                if (count == 1) {
                    // 如果次数为1，则把前一个元素添加到新数组中
                    array[index] = array[i - 1];
                    index++;
                }
                // 重置当前元素出现的次数
                count = 1;
            }
        }
        // 处理最后一个元素
        if (count == 1) {
            array[index] = array[array.length - 1];
            index++;
        }
        return index;
    }

    public static void printList(String msg, int[] arr, int size) {
        System.out.println("\n通过" + msg + "打印");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7, 8, 9, 9, 9, 11, 11};
        int size = deleteSomeValues(array);
        printList(" ", array, size);
    }
}
