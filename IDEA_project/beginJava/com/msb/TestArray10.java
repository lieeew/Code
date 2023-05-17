package com.msb;

import java.util.Scanner;

public class TestArray10 {
    public static int getNum(int num , int [] arr){
        int index = -1;
        for(int a = 0;a < arr.length;a++) {
            if(num == arr[a]){
                index = a;
            }
        }
        return index;
    }
    public static void main(String[] arges){
        int [] arr = {12, 85, 96, 32, 25, 71, 26};
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要查询的数:");
        int a = sc.nextInt();
        int num = getNum(a,arr);
            if(num  != -1){
            System.out.println("您输入想要查询的数的序号为:"+num);
            }else{
            System.out.println("没有找到此数");
        }
    }
}
