package com.msb;

//import java.util.Scanner;
//
//public class TestFor08 {
//    public static void main(String[] arges){
//        /**实现一个功能：
//         【1】请录入10个整数，当输入的数是666的时候，退出程序。
//         【2】判断其中录入正数的个数并输出。
//         【3】判断系统的退出状态：是正常退出还是被迫退出。  // 两种情况想到用boolean*/
//        Scanner sc = new Scanner(System.in);
//        int count = 0 ;
//        for ( int n = 1; n <= 10; n++){
//            System.out.println("请录入第"+ n +"个整数");
//            int num = sc.nextInt();
//            if (num > 0){
//                count++;
//            }
//            if (num == 666){
//                System.out.println("非正常退出");
//                break;
//            }else if(n == 10){
//                System.out.println("正常退出");
//            }
//        }System.out.println("正常输入的数"+ count);
//    }
//}*/


import java.util.Scanner;

/**实现一个功能：
 //         【1】请录入10个整数，当输入的数是666的时候，退出程序。
 //         【2】判断其中录入正数的个数并输出。
 //         【3】判断系统的退出状态：是正常退出还是被迫退出。*/


public class  TestFor08{
    public static void main(String[] arges){
        boolean flage = true;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        for(int a = 1;a <= 10;a++){
            System.out.println("请输入第"+a+"个整数");
            int num = sc.nextInt();
            if (num > 0){
                count++;
            }
            if(num == 666){
                flage = false;
                break;
            }
        }
        if (flage == true){ //这里是等于不是赋值!!!!!!
            System.out.println("正常退出");
        }else {
            System.out.println("非正常退出");
            }System.out.println("正数个数为"+count);
        }
    }























