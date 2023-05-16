package Day27;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/20 - 11 - 20
 * @Description: Day27
 */
public class InputStreamReaderTest {
    /**
     * InputStreamRead() 有字节的输入转化为字符的输入流
     * 注意:
     *   read()的有参数和无参数的区别之一是一次读几个
     */
    @Test
    public void test1() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            File file = new File("WordCount.txt");
            fis = new FileInputStream(file);
            // 这里构造器的参数编码集, 是文件存储时的编码集, 否则乱码
            isr = new InputStreamReader(fis, "UTF-8");

            char[] curf = new char[2];
            int len;
            while ((len = isr.read(curf)) != -1) {// read()的有参数和无参数的区别之一是一次读几个
                String s = new String(curf, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (isr != null) isr.close();
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

    @Test
    public void test2() {
        InputStreamReader isr = null;// 可以指明文件存储时的编码集
        OutputStreamWriter osw = null;// 可以指明, 文件输出时的编码集, 由字符数组转化为对格式的字节数组
        try {
            // 1. 造文件, 造流
            File file1 = new File("WordCount.txt");
            File file2 = new File("WordCount_gbk.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis, "utf-8");
            osw = new OutputStreamWriter(fos, "gbk");

            // 2. 操作数据
            char[] cbuf = new char[5];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(isr != null) isr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if(osw != null) osw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

 }
