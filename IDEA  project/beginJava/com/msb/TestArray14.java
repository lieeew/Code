package com.msb;

import java.util.Arrays;
import java.util.Scanner;

public class TestArray14 {
    public static void main (String[] arges) {
        int [] arr = {12,16,45,95,35,63,74,99,100,666};
        System.out.println("删除前的数组为:"+ Arrays.toString(arr));
        Scanner sc = new Scanner (System.in);
        System.out.print("请输入你要删除的序号:");
        int index = sc.nextInt(); // 输入要删除的序号
        for (int a = index; a <= arr.length - 2; a++) {
            arr [a] = arr [a + 1];
        }
        arr [arr.length - 1] = 0; // 最后一个赋值为0
        System.out.println("删除后的数组:"+Arrays.toString(arr));
    }
}
