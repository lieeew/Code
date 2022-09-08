package JavaTest;

import java.util.Scanner;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/22 - 08 - 22
 * @Description: Test
 */
public class Peach2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入需要查询的日期:");
        Peach2 teat = new Peach2();
        int a = teat.peach(sc.nextInt());
        if (a == -1) {
            System.out.println("请输入真确的日期");
        }else {
            System.out.println("你要查找的桃子数量为 :" + a);
        }
    }
    public int peach (int day) {
        if (day == 10) {
            return 1;
        }else if (day >= 1 && day <= 9) {
            return (peach(day + 1) + 1) * 2;
        }else {
            System.out.println("输入的day应该为1-10");
            return -1;
        }
    }
}
