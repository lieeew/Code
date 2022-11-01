package com.msb;

public class TestFor10 {
    public static void main(String[]arges) {
        /*//打印长方形
        for (int i = 1;i <= 6;i++){//控制行数
            System.out.println();
            for(int a = 0;a <= 10;a++){//控制*的个数
                System.out.print("*");
            }
        }*/
//        for(int j = 1;j <= 4;j++){
//            for(int a =1; a <= 5;a++){
//                System.out.print(" ");
//            }
//            for(int a =1; a <= 9;a++){
//                System.out.print("*");
//            }System.out.println();
//        }
       //打印平行四边形
        /*
            *******
           *******
          *******
        *******
         */
//        for(int j = 1;j <= 4;j++){
//            System.out.println();
//            for(int a = 1;a <= 4-j;a++){
//                System.out.print(" ");
//            }
//            for(int a = 1;a <= 7;a++){
//                System.out.print("*");
//            }
//        }
        /*打印三角形
            *
           ***
          *****
         *******
         */

//                for(int j = 1;j <= 4;j++){
//            System.out.println();
//            for(int a = 1;a <= 4-j;a++){
//                System.out.print(" ");
//            }
//            for(int a = 1;a <= (2*j-1);a++){
//                System.out.print("*");
//            }
//        }
                //打印倒三角形
        /*

       *****
        ***
         *


         */
        for(int j = 1;j <= 4;j++){
            System.out.println();
            for(int a = 1;a <= 9-j;a++){
                System.out.print(" ");
            }
            for(int a = 1;a <= (2*j-1);a++){
                System.out.print("*");
            }
        }
        for(int j = 1;j <= 4;j++){
            System.out.println();
            for (int a = 1;a <=(j+5);a++ ){
                System.out.print(" ");
            }
            for (int a = 1;a <= (7-2*j);a++){
                System.out.print("*");
            }
        }
    }
}

