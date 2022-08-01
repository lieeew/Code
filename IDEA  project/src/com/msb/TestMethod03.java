package com.msb;

import java.util.Scanner;

public class TestMethod03 {
    public static void  yourGuss(int yourGuessNum){
        int myNum = (int)(Math.random()*6+1);//Math.random()  生成0.0 ~ 1.0（不包含） 之间的一个伪随机数。
        System.out.println(yourGuessNum == myNum ? "猜对了" : "猜错了");

    }
    public static void main(String[] arges) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入你猜的数");
//        int yourGuessNum = sc.nextInt();
//        int myNum = 10;
//        System.out.println(yourGuessNum == myNum ? "猜对了" : "猜错了");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你猜的数:");
        int yourGuessNum = sc.nextInt();
        yourGuss (yourGuessNum);
    }

}

