package Day27.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/19 - 11 - 19
 * @Description: Day27.exer
 */
public class BufferedTest {

    /**
     *实现图片加密操作。
     * m , n 通过亦或^相互转化
     *  m ^ n ^ n == m
     */
    @Test
    public void testPicture() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("wallhaven-e7l93k.jpg"); // 内部依然是调用构造器 new File("");
            fos = new FileOutputStream("雷电将军.jpg");

            byte[] bytes = new byte[5];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                for (int i = 0; i < len; i++) {// 不能用增强for
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fos.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 解密
    @Test
    public void teat2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("雷电将军.jpg"); // 内部依然是调用构造器 new File("");
            fos = new FileOutputStream("雷电将军解密.jpg");

            byte[] bytes = new byte[5];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                for (int i = 0; i < len; i++) {// 不能用增强for
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fos.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
