package Day15exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/21 - 09 - 21
 * @Description: Day15exer
 */
public class InnerClassTest2 {
    public static void main(String[] args) {

    }

    public void method() {

        final int num = 10; // jdk7及之前不可以省略final jdk7之后可以省略final

        class AA {

            public void method2() {
                System.out.println(num); // 可以输出num
            }
        }
    }
}

