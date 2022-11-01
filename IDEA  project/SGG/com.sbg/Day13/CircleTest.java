package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/5 - 09 - 05
 * @Description: Day13
 */
public class CircleTest {
    public static void main(String[] args) {

        Circle circle1 = new Circle(2.0);
        Circle circle2 = new Circle("white",2.0,2.0);

        System.out.println("颜色是否相同:" + circle1.getColor().equals(circle2.getColor()));

        System.out.println("半径是否相等:" + circle1.equals(circle2));

        System.out.println(circle1);

        System.out.println(circle1.toString());

    }
}
