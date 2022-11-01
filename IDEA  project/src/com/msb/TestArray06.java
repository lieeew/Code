package com.msb;

public class TestArray06 {
    public static void main(String[] arges){
        //求数组中的最大值
       int [] arr = {13,95,96,45};
       int MaxNum = arr[0];
       for(int a = 1;a <= arr.length-1;a++){
           if(MaxNum < arr[a]){
               MaxNum = arr[a];
           }
       }
        System.out.println(MaxNum);
    }
}

