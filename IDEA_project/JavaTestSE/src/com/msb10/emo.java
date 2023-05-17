package com.msb10;
import static java.lang.Math.*;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/2 - 08 - 02
 * @Description: com.msb10
 */
public class emo {
        //这是一个main方法，是程序的入口：
        public static void main(String[] args) {
            System.out.println(random());
            System.out.println(PI);
            System.out.println(round(5.6));
        }
        //在静态导入后，同一个类中有相同的方法的时候，会优先走自己定义的方法。
        public static int round(double a){
            return 1000;
        }
    }


