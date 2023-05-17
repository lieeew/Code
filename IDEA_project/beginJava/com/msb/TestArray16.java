package com.msb;

public class TestArray16 {
    public static void main (String[] arges) {
//        可变参数：作用提供了一个方法，参数的个数是可变的 ,解决了部分方法的重载问题
//        int...num       int 类型的可变参数
//        dou[ble...num    double 类型的可变参数
//        boolean...num   boolean 类型的可变参数
        method(10);
        method ();
        method (10,50,90);
        method (new int [] {10,50,60,90,40}); //  new int [] {}     new int [] {}     int[] arr = new int [] {}

    }
    public static void method (int...num) {
        for (int i : num) {
        System.out.println(i);
        }
        System.out.println("-----------");

        System.out.println();
        }
}