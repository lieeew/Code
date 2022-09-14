package Day13;

import org.junit.Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/14 - 09 - 14
 * @Description: Day13
 */
public class WrapperTest4 {

    @Test
    public void test1 () {
        // string ---> 包装类

        String s = "19";
        int i = Integer.parseInt(s);
        System.out.println(i + 1);

        // 包装类 --> String

        Integer a = new Integer(13);
        String s1 = String.valueOf(a);
        System.out.println(s1);
    }
}
