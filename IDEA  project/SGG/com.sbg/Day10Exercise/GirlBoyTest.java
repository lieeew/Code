package Day10Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/19 - 08 - 19
 * @Description: Day10Exercise
 */
public class GirlBoyTest {
    public static void main(String[] args) {
        Boy boy = new Boy("lihua",23);
        boy.shout(boy);
        Girl girl = new Girl("lili", 18);
        Girl girl1 = new Girl("nana", 19);
        girl.compare(girl1);
        girl.marry(boy);

    }
}
