package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/6 - 09 - 06
 * @Description: Day13
 */
public class WrapperTest2 {
    public static void main(String[] args) {
        int num = 10;
        WrapperTest2 test = new WrapperTest2();
        test.method(num); // 自动装箱

        Integer i = num; // 自动装箱

        Integer  a = new Integer(12);
        System.out.println(a + 1);

    }
    public void method (int num) {
        System.out.println(num);
    }
}
