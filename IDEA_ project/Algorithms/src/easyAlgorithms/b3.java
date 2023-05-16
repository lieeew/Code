package easyAlgorithms;

import java.util.Scanner;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/1 - 11 - 01
 * @Description: easyAlgorithms
 */


/**
 * 课堂任务：系统要求用户输入账号（学号后四位），密码1234，如果账号和密码同时正确，进入计算器模式，要求客户输入计算数字，
 * 选择计算方法，输出相应得数；若账号或密码错误，系统提示“您的账号或密码错误!请重新输入！"，输入三次错误，系统输出”该账号被冻结！“
 */
public class b3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = 0; // 记录错误的次数
        boolean isFlage = true;

        while (isFlage) {
            System.out.println("请输入账号:");
            int account = sc.nextInt(); // 1411
            System.out.println("请输入密码");
            int password = sc.nextInt(); // 1234
            if (password != 1234 || account != 1411) {
                System.out.println("您的账号或密码错误!请重新输入！");
                sum++;
            }
            if (sum == 3) {
                System.out.println("该账号被冻结！");
                isFlage = false;
            }
            if (password == 1234 && account == 1411) {
                System.out.println("进入系统!");
                System.out.println("请输入1-4分别代表,加减乘除");
                int isChoice = sc.nextInt();
                System.out.println("请输入第一个数:");
                double b1 = sc.nextDouble();
                System.out.println("请输入第二个数:");
                double b2 = sc.nextDouble();
                switch (isChoice) {
                    case 1:
                        System.out.println("两个数的和为" + (b1 + b2));
                        break;
                    case 2:
                        System.out.println("两个数相减为:" + (b1 - b2));
                        break;
                    case 3:
                        System.out.println("两个数相乘:" + (b1 * b2));
                        break;
                    case 4:
                        System.out.println("两个数相除为:" + (b1 / b2));
                        break;
                    default:
                        System.out.println("请输入1-4的数字!");
                }
                isFlage = false;
            }
        }
    }
}
