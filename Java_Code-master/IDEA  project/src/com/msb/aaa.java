package com.msb;

import java.util.Scanner;

public class aaa {
    public static void yourGuess(int YourGuessNum){
        int myNum = (int)(Math.random()*6+1);
        System.out.println(myNum == YourGuessNum?"猜对了":"猜错了");
    }
    public static void main(String[] arges){
        Scanner  sc = new Scanner(System.in);
        System.out.println("请输入你猜的数字:");
        int num = sc.nextInt();
        yourGuess(num);

    }
}
