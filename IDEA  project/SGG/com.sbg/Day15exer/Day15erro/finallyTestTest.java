package Day15exer.Day15erro;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
            System.out.println(arr[2]);
            return 1;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return 2;

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return 3;
        }
        finally {
            // 一定会被执行的语句
            System.out.println("我一定会被执行"); // return 之前就会被运行
        }
    }

    @Test
    public void test3() {

        try{
            int a = 10;
            int b = 0;
            System.out.println(a / b);

        } catch(ArithmeticException e) {
            e.printStackTrace();

            int[] arr = new int[10];
            System.out.println(arr[10]);
        }catch(Exception e) {
            e.printStackTrace();
        }
//         System.out.println("我好帅啊~~");
        finally {
            System.out.println("我好帅啊~~");  // 即使catch中有异常也会执行, 大部分为硬件(数据库, 流)应该关闭, 否者占用内存
        }
    }


    @Test
    public void test4() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
             fis = new FileInputStream(file);

            int date = fis.read();

            while (date != -1) {
                System.out.println((char) date);
                date = fis.read();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(fis != null) fis.close(); // 需要判断是否为null , 否者 NullPointerException, 因为未找到对象
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
