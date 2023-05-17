package com.msb;

import java.util.Scanner;

public class TestArray08 {
    public static void main(String[] arges){
//        int[] arr ={12,58,61,100,666};
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入你要查询数组的编号:");
//        int num = sc.nextInt();
//        System.out.println("你要查询的为:"+arr[num - 1]);
        int[] arr ={12,58,61,100,666};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查询的数:");
        int num = sc.nextInt();
        int index = -1;
        for(int a = 0;a < arr.length;a++) {
            if (num == arr[a]) {
                index = a;
            }
        }
        if(index != -1){
           System.out.println("请输入你要查询:"+index);
        }else{
            System.out.println("查无此数!");
        }
    }
}
//注意细节!