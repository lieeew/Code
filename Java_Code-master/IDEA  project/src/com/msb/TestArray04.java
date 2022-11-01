package com.msb;

import java.util.Scanner;

public class TestArray04 {
    public static void main(String[] arges){
        int sum  = 0;
        int [] arr = new int [10];
        for(int a = 1;a <= 10;a++){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入第"+a+"个人的成绩:");
            int score  = sc.nextInt();
            arr[a-1] = score;
            sum += score;
        }
        System.out.println("学生分数的总和为:"+sum);
        System.out.println("学生的平均分为:"+sum/10);
//        for(int a = 1;a <= 10;a++){
//            System.out.println("第"+a+"位学生的成绩为:"+arr[a-1]);
        //倒着输出成绩;
//        for(int a = 10;a > 0;a--){
//            System.out.println("第"+a+"位学生的成绩为:"+arr[a-1]);
//        }
        for(int num:arr){
            System.out.println(num);

        }
    }

}
