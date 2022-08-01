package com.msb;

public class TestFor07 {
    public static void main(String[] arges){
        // 输出1到100被5整除的数,.每行输出6个
        int count = 0; //引入计数器
        for(int a = 1; a <= 100; a++){
            if(a%5 == 0){
                System.out.print(a + "\t");
                count++;
                if (count % 6 == 0){
                    System.out.println();   //换行
                }
            }
        }
    }
}
