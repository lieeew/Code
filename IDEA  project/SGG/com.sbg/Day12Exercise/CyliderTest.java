package Day12Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/31 - 08 - 31
 * @Description: Day12Exercise
 */
public class CyliderTest {
    public static void main(String[] args) {
        Cylinder test = new Cylinder();
        test.setLength(10.0);
        test.setRadius(2.0);
        double area = test.findArea();
        System.out.print("圆柱的表面积"+area);
        System.out.println();
        double volume = test.findVolume();
        System.out.print("面积为:" + volume );
        System.out.println("*************");
        Cylinder c2 = new Cylinder();
        System.out.print("圆柱的表面积" + c2.findArea());
        System.out.println();
        System.out.print("面积为:" + c2.findVolume());

    }
}
