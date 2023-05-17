package Day14;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/8 - 09 - 08
 * @Description: Day14
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println("第一个圆的id : " + c1.getId());
        Circle c2 = new Circle();
        System.out.println("第二个圆的id : " + c2.getId());

        System.out.println("总共造了" + Circle.getTotalNum() + "个圆");

    }
}
class Circle {
    private double radius;
    private int id;
    private static int init = 1001;
    private static int TotalNum ;

    public Circle() {
        id = init ++;
        TotalNum ++;
    }

    public Circle(double radius) {
        this.radius = radius;
        id = init ++;
        TotalNum ++;
    }

    public double getRadius() {
        return radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotalNum() {
        return TotalNum;
    }

    public double getArea () {
        return 3.14 * radius * radius;
    }
}