package com.msb;
//public class TestFor05{
//    public static  void main(String[] arges){
//        //输出一到一百被六整除的数
//        for (int i = 0;i <= 100;i++){
//            if(i % 6 != 0){
//                continue;
//
//            }System.out.println(i);
//        }
//    }
//}

public class TestFor05{
    public static void main(String[] arges){
        outer:
        for (int a = 0; a <= 100;a++){
            while(a == 36) {
                System.out.println("---------");
                break;
            }System.out.println(a);
        }
    }
}