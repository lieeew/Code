package Day13;

import org.junit.Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/6 - 09 - 06
 * @Description: Day13
 */
public class JuniteTest {
    @Test
    public void copy () {
        System.out.println("hello");
    }

    @Test
    public void viewTest () {
        Object o1 = true ? new Integer(1) : new Double(2);
        System.out.println(o1); // 1.0
    }

}
