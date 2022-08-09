package DAY08.Exercise;

import java.util.Scanner;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/9 - 08 - 09
 * @Description: DAY08.Exercise
 */
public class CircleTest {
    public static void main(String[] args) {
        System.out.print("请输入圆的半径(精确到小数):");
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        Circle s = new Circle();
        double w = s.S(r);
        System.out.println("面积为:" + w);
    }
}
// 圆
class Circle {
    // 属性
    double r;
    final double PI = 3.1415;
    // 方法
    public double S (double r) {
        double s = PI * r * r;
        return s;

    }
}