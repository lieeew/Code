package com.msb;

public class TestArray11 {
    public static void main(String[] arges){
        int [] arr ={12,65,98,11,45,23,10};
        //           0  1   2  3  4  5  6
        System.out.print("增加前的数组:");
        for (int a = 0; a < arr.length; a++) {
            if (a != arr.length-1) {
                System.out.print(arr[a]+",");
            }else {
                System.out.print(arr[a]);
            }
        }
        /*arr[6] = arr[5];
        arr[5] = arr[4];
        arr[4] = arr[3];*/
        int index= 1;
        for (int a = arr.length-1; a > index; a--) {
            arr[a] = arr[a-1];
        }
        arr[index] = 666;
        System.out.print("\n"+"增加后的数组:");
        for (int a = 0; a < arr.length; a++) {
            if (a != arr.length-1) {
                System.out.print(arr[a]+",");
            }else {
                System.out.print(arr[a]);
            }
        }
    }
}


