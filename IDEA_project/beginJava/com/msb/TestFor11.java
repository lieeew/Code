package com.msb;

public class TestFor11 {
    public static void main(String[] arges){
        /*打印空心菱形
        *
       * *
      *   *
     *     *
      *   *
       * *
        *
         */
        for(int j =1;j <= 4;j++){
            for(int i = 1;i <= (9-j);i++){
                System.out.print(" ");
            }
            for(int i = 1;i <= (2*j-1);i++){
                if(i == 1|| i==(2*j-1)){  System.out.print(" ");
            }
        }
                System.out.println();
      }
        for(int j=1;j<=3;j++){//j:控制行数
            //加入空格：
            for(int i=1;i<=(j+5);i++){//i:控制空格的个数
                System.out.print(" ");
            }
            //*********
            for(int i=1;i<=(7-2*j);i++){//i:控制*的个数
                if(i==1||i==(7-2*j)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            //换行：
            System.out.println();
        }

    }
}
