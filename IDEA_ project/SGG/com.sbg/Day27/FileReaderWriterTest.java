package Day27;

import org.junit.Test;

import java.io.*;

/**
 *
 * 一 : 流的分类
 *    单位
 *    流向
 *    角色
 * 二 : 留的结构体系
 *
 *  抽象类                            节点流                      缓冲流(处理流的一种)
 *  InputStream                   FileInputStream                BufferedInputStream
 *  OutputStream                  FileOutputStream               BufferedOutputStream
 *  Reader                        FileReader                     BufferedReader
 *  Writer                        FileWriter                     BufferedWriter
 *
 *  不能用字符流处理图片等字节流
 * @Auther: QiuXinYu
 * @Date: 2022/11/17 - 11 - 17
 * @Description: Day27
 */
public class FileReaderWriterTest {
    /*
    1 将Day27下面的hello.text文件内容读取到程序中, 并输出到控制台
    2 异常的处理, 为了保证资源一定被关闭, 需要try-catch-finally处理, 如果抛出那么最后面可以不回执行
    3 需要确报读入的文件一定要存在, 否者会报FileNotFoundException
     */
    @Test
    public void FileReaderTest() {
        FileReader fr = null;
        try {
            // 1. 实例化File类的对象, 指明文件
            File file = new File("hello.text"); // 相较于当前的Module
//        System.out.println(file.getAbsolutePath());
            // 2. 提供具体的流
            fr = new FileReader(file);
            // 3. 数据的读入
            // read()返回一个字符串. 如果达到文件末尾, 返回-1
            int read = fr.read();
            while (read != -1) {
                System.out.print((char) read);
                read = fr.read(); // 相当于遍历下一个, 指正下移(类似next())
            }
//        方式二:
//        int date;
//        while ((date = fr.read()) != -1) {
//            System.out.println((char) read);
//
//        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 流的关闭 后果:内存泄漏
//            try {
//                if (fr != null)
//                    fr.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

            // 方式二 和方式一没有区别
             if (fr != null) {
                 try {
                     fr.close();
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
             }
        }
    }

    /**
     * 对read()方法的升级 : 使用read()的重载方法
     * read()也有类似String的public int read(char cbuf[], int off, int len)构造器, 我们一般用的是他的特殊情况len=cbuf.length();
     *错误的原因 : 某个长度的数组, 对于每一轮都不会是空的, 而是用之后的数据覆盖上一轮, 所以会出现错误
     */
    @Test
    public void test2()  {
        FileReader fr = null;
        try {
            // 1. File类的实例化
            File file = new File("hello.text");
            // 2. StringBuffer的实例化
            fr = new FileReader(file);
            // 3. 读入操作
            char[] cbuff = new char[5];

            // 正确写法一
//            int len;
//            while ((len = fr.read(cbuff)) != -1) {
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuff[i]);
//                }
//            }
            // 正确写法二
//            int len;
//            while ((len = fr.read(cbuff)) != -1) {
//                String s = new String(cbuff, 0, len);
//                System.out.print(s);
//            }

            // 错误写法
//            int len;
//            while ((len = fr.read(cbuff)) != -1) {
//                String s = new String(cbuff);
//                System.out.print(s);
//            }

            // 错误写法二
            int len;
            while ((len = fr.read(cbuff)) != -1) {
                for (int i = 0; i < cbuff.length; i++) {
                    System.out.print(cbuff[i]);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fr != null) {
                // 4.关闭流
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /*
    把内存中写出的数据到硬盘

    说明:
     1. 输出操作, File对应的文件可以不存在, 并不会报异常
     2. 如果不存在, 总结创建个
        如果存在, 根据构造器的不同选择不同的方式:
                 new FileWriter("haha.txt") / new FileWriter("haha.text" , false) 直接覆盖原文件
                 new FileWriter("haha.txt, true) 不覆盖原文件, 而是在原文件中添加内容

     */
    @Test
    public void testFileWriter()  {
        FileWriter fw = null;
        try {
            // 1. 提供File类的对象, 指明写出到的文件
            File file = new File("haha.txt");
            // 2. 提供FileWriter的实例化对象, 用于数据的写出
            fw = new FileWriter(file, true);
            // 3. 写入操作
            fw.write("I have a dream!");
            fw.write(" you need have a dream!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fw != null) {// 可能会有空指针异常
                try {
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 读入写出测试
     */
    @Test
    public void test() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 1. File类
            File srcFile = new File("haha.txt");
            File destFile = new File("copy.txt");
            // 2. 创建对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            // 3. 调用方法
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally { // 两个处理异常时候都会执行, 因为try-catch-finally会把异常处理
//            if (fw != null) {
//                try {
//                    fw.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if (fr != null) {
//                try {
//                    fr.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }

            if (fw != null) {
                try {
                    if (fw != null)  fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        if (fr != null)  fr.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
