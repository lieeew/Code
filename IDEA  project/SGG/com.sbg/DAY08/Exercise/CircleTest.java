package DAY08.Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/9 - 08 - 09
 * @Description: DAY08.Exercise
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle s = new Circle();
        s.r = 3.1;
        double w = s.S();
        System.out.println("面积为:" + w);
    }
}
// 圆
class Circle {
    // 属性
    double r;
    final double PI = 3.1415;
    // 方法
    public double S () { // 不需要定义变量,因为属性有半径
        double s = PI * r * r;
        return s;

    }
}