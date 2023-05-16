package com.msb;

import java.util.Scanner;

public class TestArray01 {
    public static void main(String[] arges){
        int sum = 0;
        for(int i =1;i <= 10;i++){
            Scanner sc = new Scanner(System.in);
            System.out.print("请录入第"+i+"个学生的成绩");
            int soccer = sc.nextInt();
            sum += soccer;
        }
        System.out.println("学生成绩的和为:"+sum);
        System.out.println("学生成绩的平均数为:"+sum/10);
    }
}
