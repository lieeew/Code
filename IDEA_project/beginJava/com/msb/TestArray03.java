package com.msb;

import java.util.Scanner;

public class TestArray03 {
    public static void main(String[] arges){
        int sum = 0;
        int [] arr= new int [10];
        for(int a = 1; a <= 10; a++){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入第"+a+"个成绩:");
            arr [a-1] = sc.nextInt();
            sum += arr[a-1];
        }
        System.out.println("学生成绩的和为:"+sum);
        System.out.println("学生成绩的平均数为:"+sum/10);
        Scanner sc = new Scanner(System.in);
        System.out.println("如果需要查询请输入:");
        String Find= sc.next();
        if(Find.charAt(0) == '查'){
            System.out.println("需要查询成绩的位次:");
            int count = sc.nextInt();
            System.out.println("您要查询的成绩:"+arr[count-1]);
        }else{
            System.out.println("谢谢使用!");
        }
    }
}
