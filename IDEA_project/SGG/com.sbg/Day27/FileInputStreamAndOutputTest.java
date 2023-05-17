package Day27;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/18 - 11 - 18
 * @Description: Day27
 */

/*
对于文本文件(.txt .java .c .cpp), 用字符流
对于非文本文件(.jpj  .doc  .ppt  .mp4), 用字节流
 */
public class FileInputStreamAndOutputTest {
    /**
     * 使用字节流读取文件
     * 由于, 中文占三个字符, 可能出现乱码
     */
    @Test
    public void test2()  {
        FileInputStream fis = null;
        try {
            // 1 造文件
            File file = new File("hello.text");
            // 2 提供流
            fis = new FileInputStream(file);
            // 3 调方法
            int len;
            byte[] bytes = new byte[5];
            while ((len = fis.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4 关闭流
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File("wallhaven-e7l93k.jpg");
            File file1 = new File("potato");

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] bytes = new byte[5];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    // 封装成方法
    public void copyFile(String srcFile, String desFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File(srcFile);
            File file1 = new File(desFile);

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     *  复制花费的时间为:1184
     *
     *  复制花费的时间为:185390
     *
     */
    @Test
    public void teat2() {
        long start = System.currentTimeMillis();

        String Start = "D:\\下载\\Video\\鱼皮.mp4";
        String End = "D:\\SOFT\\destbook\\yupi.mp4";
        copyFile(Start, End);

        long end = System.currentTimeMillis();
        System.out.println("复制花费的时间为:" +( end - start));

    }
}
