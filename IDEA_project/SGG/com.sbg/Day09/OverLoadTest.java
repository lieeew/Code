 package Day09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/13 - 08 - 13
 * @Description: Day09
 */
public class OverLoadTest {
    public static void main(String[] args) {
        OverLoadTest util = new OverLoadTest();
        util.sum(1,2);

    }
    /*public void sum (int a, int b) {
        System.out.println("1");
    }*/
    public void sum (double a, double b) {
        System.out.println("2");
    }
    public void sum (String a, String b) {
        System.out.println("3");
    }
}

