package Day15erro;

import org.junit.Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/23 - 09 - 23
 * @Description: Day15erro
 */


public class finallyTestTest {

    @Test
    public void test2() {
        int i = test();
        System.out.println(i);
    }

    public int test() {

        try {
            int[] arr = {12,34,76,9};
            System.out.println(arr[4]);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return 1;

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 2;
        }
        finally {
            System.out.println("我一定会被执行"); // return 之前就会被运行
//            return 3;
        }
        return 0;
    }
}
