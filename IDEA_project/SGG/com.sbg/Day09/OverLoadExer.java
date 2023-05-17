package Day09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/13 - 08 - 13
 * @Description: Day09
 */

/*
 * 1.编写程序，定义三个重载方法并调用。方法名为mOL。
	三个方法分别接收一个int参数、两个int参数、一个字符串参数。
	分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
	在主类的main ()方法中分别用参数区别调用三个方法。

	2.定义三个重载方法max()，
	第一个方法求两个int值中的最大值，
	第二个方法求两个double值中的最大值，
	第三个方法求三个double值中的最大值，
	并分别调用三个方法。

 *
 *
 */
public class OverLoadExer {
    public static void main(String[] args) {
        OverLoadExer exer = new OverLoadExer();
        exer.mOL(2);
        exer.mOL("芜湖");
        exer.mOL(1,4);
        exer.max(1.2,1.9,16.8);

    }
    //   第一题
    public void mOL (int a) {
        System.out.println(a * a);
    }
    public void mOL (int a, int b) {
        System.out.println(a * b);
    }
    public void mOL (String a) {
        System.out.println(a);
    }


    // 第二题
    public void  max (int a, int b) {
        System.out.println((a > b) ? a : b); // 三木运算符
    }
    public double max (double a, double b) {
        if (a > b) {
            return a;
        }else {
            return b;
        }
    }
    public void max (double num1, double num2, double num3) {
       /*double[] arr = {num1,num2,num3};
       double MaxNum = num1;
       for (int a = 0; a < arr.length; a++) {
           if (arr[a] > MaxNum) {
               MaxNum = arr[a];
           }
       }
        System.out.println(MaxNum);*/
       double num = (num1 > num2) ? num1 : num2;
       System.out.println((num > num3) ? num : num3);
    }
}
