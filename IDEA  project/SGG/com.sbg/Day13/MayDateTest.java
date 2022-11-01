package Day13;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/4 - 09 - 04
 * @Description: Day13
 */
public class MayDateTest {
    public static void main(String[] args) {
        MayDate m1 = new MayDate(4, 9, 2022);
        MayDate m2 = new MayDate(4, 9, 2022);

        if (m1 == m2) {
            System.out.println("m1 == m2");
        }else {
            System.out.println("m1 != m2");
        }

        if (m1.equals(m2)) {
            System.out.println("m1 is equal to m2");
        } else {
            System.out.println("m2 is not equals to m2");
        }
    }
}
