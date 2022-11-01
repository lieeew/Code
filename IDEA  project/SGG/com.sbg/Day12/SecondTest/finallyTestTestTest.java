package Day12.SecondTest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/24 - 09 - 24
 * @Description: SecondTest
 */


/**
 *
 * |------运行时异常(unchecked,RuntimeException)
 *  					|-----NullPointerException
 *   					|-----ArrayIndexOutOfBoundsException
 *  					|-----ClassCastException
 *   					|-----NumberFormatException
 *   					|-----InputMismatchException
 *  					|-----ArithmeticException
 */
public class finallyTestTestTest {

    @Test
    public void test() {
        int[] arr =null;
        try {
            System.out.println(arr[1]);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            System.out.println("我一定会被执行");
        }

    }

    @Test
    public void test2() {
        int[] arr = {12,46,79,20};
        try {
            System.out.println(arr[4]);
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }finally {
            System.out.println("我一定会被执行");
        }
    }

    @Test
    public void test3() {
        int i = test4();
        System.out.println(i);


    }

    public int test4() {
        try {
            int[] arr = {12,46,79,20};
            System.out.println(arr[4]);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 2;
        }
        return 3 ;
    }

}