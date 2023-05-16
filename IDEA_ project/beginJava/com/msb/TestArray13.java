package com.msb;

import java.util.Scanner;

public class TestArray13 {
    public static void main (String[] arges) {
        int [] arr = {12,56,96,100,666,15,23,48,96};
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你要删除的序号:");
        int index = input.nextInt();
//        arr [2] = arr [3];
//        arr [3] = arr [4];
//        arr [4] = arr [5];
        for (int a = index; a < arr.length - 1;a++) {
            arr [a] = arr [a + 1];
        }
        arr [arr.length - 1] = 0;
        System.out.print("更改后的为:");
        for (int a = 0;a < arr.length;a++) {
            if (a != arr.length-1) {
                System.out.print(arr [a] + ",");
            }else {
                System.out.print(arr [a]);
            }
        }
    }
}
