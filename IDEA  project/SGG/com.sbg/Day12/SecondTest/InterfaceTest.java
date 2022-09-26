package Day12.SecondTest;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/18 - 09 - 18
 * @Description: SecondTest
 */
public class InterfaceTest {
    public static void main(String[] args) {
        ComparableCircle circle = new ComparableCircle(12.9);
        ComparableCircle circle1 = new ComparableCircle(13.0);


        int compareNum = circle.compareTo(new String("你好"));
        if (compareNum > 0) {
            System.out.println("前者大");
        } else if (compareNum < 0) {
            System.out.println("后者大");
        } else {
            System.out.println("一样大");
        }
    }
}
