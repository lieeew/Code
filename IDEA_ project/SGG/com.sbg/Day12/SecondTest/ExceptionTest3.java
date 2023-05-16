package Day12.SecondTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/24 - 09 - 24
 * @Description: SecondTest
 */
public class ExceptionTest3 {
    public static void main(String[] args) {
        try {
            test2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void test2() throws IOException {
        test1();
    }
    public static void test1() throws FileNotFoundException, IOException {
        File file = new File("hello.txt"); // 这里挂了, 后面的代码就没有机会运行
        FileInputStream fis = new FileInputStream(file);

        int date = fis.read();

        while (date != -1) {
            System.out.println((char) date);
            date = fis.read();
        }
    }

    public void test3() {

    }
}




