package Day15exer.Day15erro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/24 - 09 - 24
 * @Description: Day15erro
 */
public class ExceptionTest3 {
    public static void main(String[] args) {
        try {
            test2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     *  IOException 是FileNotFoundException的父类可以省略 , 写两个处理类型就不一样, 写一个处理就一样
     * @throws IOException
     */
    public static void test2() throws IOException{
        test1();
        test3();
    }



    public static void test1() throws IOException, FileNotFoundException {
        File file = new File("hello.txt"); // 这里挂了, 后面的代码就没有机会运行
        FileInputStream fis = new FileInputStream(file);

        int date = fis.read();

        while (date != -1) {
            System.out.println((char) date);
            date = fis.read();
        }
    }

    public static void test3() {
        try {
        int[] arr = new int[10];
        System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}

