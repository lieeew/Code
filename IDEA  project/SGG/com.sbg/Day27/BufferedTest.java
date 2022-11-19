package Day27;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/18 - 11 - 18
 * @Description: Day27
 */

/*
BufferedInputStream
BufferedOutputStream
BufferedReader
BufferedWriter

作用: 提高流的读取和写入速度

缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO读取次数，从而提高读写的效率。
 */
public class BufferedTest {

    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 造文件
            File srcFile = new File("wallhaven-e7l93k.jpg");
            File destFile = new File("wallhaven-e8l93k.jpg");

            // 2. 创建流
            // 2.1 造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 2.2 造缓存流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3.赋值
            byte[] bytes = new byte[10];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4关闭流
            // 由外到内, 由里到外
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            // 说明 外层流关闭的同时, 内层流也同时会自动关闭; 关于内层流的关闭, 可以省略
//            fis.close();
//            fos.close();
        }
    }

    // 复制的方法
    public void copyFile(String subFile, String desFile) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 造文件
            File file1 = new File(subFile);
            File file2 = new File(desFile);

            //2.造流
            // 2.1 节点流
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            // 2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3.复制
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes);// 内部会自动调用flush(), 刷新缓存区
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 流的关闭
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
// 花费的时间为:444
    @Test
    public void test3() {
        long start = System.currentTimeMillis();

        String Start = "D:\\下载\\Video\\鱼皮.mp4";
        String End = "D:\\SOFT\\destbook\\yupi.mp4";
        copyFile(Start, End);

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为:" + (end - start));
    }
}
