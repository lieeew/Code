package com.msb;

import java.util.Scanner;

public class TestArray09 {
    public static void findNm(int num,int []arr){
        int index = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入想要查询的数:");
        int input = sc.nextInt();
        for(int a =0;a <arr.length;a++){
            if(input == arr[a]){
               index = a;
            }
        }
            if(index == -1){
                System.out.print("没有找到此数");
            }else{
                System.out.println("您输入想要查询的数的序号为:"+index);
        }
    }
    public static void main(String[] arges) {
        int[] arr = {12, 65, 9, 5, 8, 46, 94, 1, 6, 61, 4, 64, 94};
        findNm(6, arr);
    }
}