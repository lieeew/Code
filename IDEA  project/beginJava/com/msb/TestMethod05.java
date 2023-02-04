package com.msb;

public class TestMethod05 {
    public static int add(int num1,int num2){
        return num1+num2;
    }
    public static int add(int num1,int num2,int num3){
        return num1+num2+num3;
    }
    public static double add(double num1,double num2,double num3){
        return num1 +num2 +num3;
    }
    public static void main(String[] arges){
        //byte,short,char-->int--->long--->float--->double(由低到高)
        System.out.println(add(20,60));
        System.out.println(add(12,65,92));
        System.out.println(add(1.6,23.6,89.8));
    }

}
