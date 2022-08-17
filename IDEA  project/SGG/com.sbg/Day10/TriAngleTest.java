package Day10;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/17 - 08 - 17
 * @Description: Day10
 */
public class TriAngleTest {
    public static void main(String[] args) {
        TriAngle test = new TriAngle();
        test.setBase(13.4);
        test.setHeight(14.9);
        double a = test.getBase();
        double b = test.getHeight();
        test.s(a,b);
    }
}
