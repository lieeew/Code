package com.msb;

public class TestMethod01 {
    public static int addNum(int num1,int num2){
        int sum = 0;
        sum += num1;
        sum += num2;
        return sum;
    }
    public static void main(String[] arges){
        int num = addNum(785484848,45);
        System.out.println(num);

    }
}
