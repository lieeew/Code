package Day15erro;

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/22 - 09 - 22
 * @Description: Day15erro
 */

/**
 *
 *        java.lang.Throwable
 *      * 		|-----java.lang.Error:一般不编写针对性的代码进行处理。
 *      * 		|-----java.lang.Exception:可以进行异常的处理
 *      * 			|------编译时异常(checked)
 *      * 					|-----IOException
 *      * 						|-----FileNotFoundException
 *      * 					|-----ClassNotFoundException
 *      * 			|------运行时异常(unchecked,RuntimeException)
 *      * 					|-----NullPointerException
 *      * 					|-----ArrayIndexOutOfBoundsException
 *      * 					|-----ClassCastException
 *      * 					|-----NumberFormatException
 *      * 					|-----InputMismatchException
 *      * 					|-----ArithmeticException
 */
public class ExceptionTestTestTest {
    @Test
    public void test1() {
        // NullPointerException
        int[] arr = null;
        System.out.println(arr[1]);
    }

    @Test
    public void test2() {
        // ArrayIndexOutOfBoundsException
        int[] arr = {1, 30, 40};
        System.out.println(arr[3]);
    }

    @Test
    public void test3() {
        // ClassCastException
        Object obj = new Date();
        String s = (String) obj;
    }

    @Test
    public void test4() {
        // NumberFormatException
        String str = "abc";
        int i = Integer.parseInt(str);
        System.out.println(i);
    }

    @Test
    public void test5() {
        // InputMismatchException
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字");
        int i = sc.nextInt();
        System.out.println(i);

    }

}