package Day28;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/22 - 11 - 22
 * @Description: Day28
 */

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 1. RandomAccessFileTest 直接继承与java.long.object,
 * 实现了DataInput和DataOutput可以是输入流也可以是输出流(但是需要造两个对象)
 * 2. 如果文件不存在, 那么直接创建
 *    如果文件存在, 那么会覆盖文件, 特点: 默认情况, 覆盖文件的内容从头开始覆盖
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile("雷电将军.jpg", "r");
            raf2 = new RandomAccessFile("雷电将军1.jpg", "rw");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = raf1.read(bytes)) != -1) {
                raf2.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (raf1 != null) raf1.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (raf2 != null) raf2.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello.txt", "rw");

            raf.write("xyz".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

