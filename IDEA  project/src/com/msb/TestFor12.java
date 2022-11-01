package com.msb;

public class TestFor12 {
    public static void main(String[] arges){
        //打印菱形
        int size = 9;
        int StartNmae = size/2+1;
        int EndName = size/2+1;
        boolean flage = true;
        for (int j = 1;j <= size;j++){
            for(int a = 1;a <= size; a++){
                if(a>=StartNmae  && EndName >=a ){  //空心菱形只需改为: a == StartName ||  a == EndName
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            if (EndName == size){
                flage = false;
            }
            if (flage){
                StartNmae--;
                EndName++;
            }else{
                StartNmae++;
                EndName--;
            }
        }

    }
}
