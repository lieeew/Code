package com.msb;
//提取TestArray11添加数组的方法.

public class TestArray12 {
    public static  void changeArray (int num ,int position, int [] arr) {
        System.out.println("修改前:");
        for (int a = 0; a < arr.length; a++) {
            if (a != arr.length-1) {
                System.out.print (arr[a]+",");
            }else {
                System.out.print (arr[a]);
            }
        }
        int index = 1; // 需要更改数组的位置
        for (int a = arr.length-1; a > index ; a--) {
            arr[a] = arr[a-1];
        }
        arr[index] = num;
        System.out.println("\n"+"修改后:");
        for (int a = 0; a < arr.length; a++) {
            if (a != arr.length-1) {
                System.out.print (arr[a]+",");
            }else {
                System.out.print (arr[a]);
            }
        }
    }
    public static void main (String[] arges){
        int [] arr = {12,52,95,161,84,616,161,61,16,655,5,88};
        changeArray(666,4,arr);
    }
}
