package com.msb;

public class TestArray07{
    public static int getMaxNum (int[]arr) {
        int MaxNum = arr[0];
        for (int a = 1; a <= arr.length - 1; a++) {
            if (arr[a] > MaxNum) {
                MaxNum = arr[a];
            }

        }
        return MaxNum;
    }
    public static void main(String[] args){
        int [] arr ={10,50,864,5,1};
        int num =getMaxNum(arr);
        System.out.println(num);
    }
}
