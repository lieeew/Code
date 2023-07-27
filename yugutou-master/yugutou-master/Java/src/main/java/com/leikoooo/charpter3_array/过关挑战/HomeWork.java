package com.leikoooo.charpter3_array.过关挑战;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author leikoooo
 */
public class HomeWork {

    /**
     * 删除相同的元素
     *
     * @param array 数组
     */
    public static int deleteSomeValues(int[] array) {
        // 定义两个指针，一个是 slow 一个是需要存入到 list 中的指针位置
        int slow = 0, valueIndex = 0;
        // 定义一个存储有效值的集合
        List<Integer> list = new ArrayList<>();

        for (int fast = 0; fast < array.length - 1; fast++) {
            if (array[fast] != array[slow]) {
                if ((fast - slow) > 1) {
                    slow = fast;
                    if (array[fast] != array[fast + 1]) {
                        valueIndex = slow;
                        list.add(array[valueIndex]);
                    }
                } else {
                    valueIndex = slow;
                    if (array[fast] != array[slow]) {
                        list.add(array[valueIndex]);
                    }
                    slow = fast;
                }
            }
        }

        // 把 list 中的数据直接取代 array 中的对应位置
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return list.size();
    }

    public static void printList(String msg, int[] arr, int size) {
        System.out.println("\n通过" + msg + "打印");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7};
        int size = deleteSomeValues(array);
        printList(" ", array, size);
    }
}
