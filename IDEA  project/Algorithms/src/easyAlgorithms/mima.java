package easyAlgorithms;

import java.util.Scanner;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/1 - 11 - 01
 * @Description: easyAlgorithms
 */


public class mima {
    public static void main(String[] args) {
        int i = 0;
        while (i < 3) {
            System.out.print("请输入账号：（学号后四位）：");
            Scanner input = new Scanner(System.in);
            int g = input.nextInt();
            System.out.println("请输入密码："); // 1234
            int h = input.nextInt();
            if (g == 4321 && h == 1234) {
                System.out.println("欢迎来到计算机");
                System.out.println("请输入第一个整数");
                int o = input.nextInt();
                System.out.println("请输入第二个整数");
                int t = input.nextInt();
                System.out.println("选择计算方法；（1、加法 2、减法 3、乘法 4、除法）；");
                int fa = input.nextInt();
                if (fa == 1) {
                    o += t;
                    System.out.println("结果为" + o);
                    break;
                } else {
                    if (fa == 2) {
                        o *= t;
                        System.out.println("结果为" + o);
                        break;
                    } else {
                        o /= t;
                        System.out.println("结果为" + o);
                        break;
                    }
                }
            } else {
                System.out.println("你的账号或密码错误，请重新输入");
                i++;
            }
        }
        System.out.println("冻结了!");
    }
}