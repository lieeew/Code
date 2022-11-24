package Day27;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 不重要
 *  标准的输入输出流
 *  打印流
 *  数据流
 * @Auther: QiuXinYu
 * @Date: 2022/11/20 - 11 - 20
 * @Description: Day27
 */

/*
标准的输入输出流
1.1
 System.in :标准的输入流, 默认键盘输入
 System.out: 标准的输出流, 默认从控制台输出
1.2
 System类的setIn(InputStream is) / setOut(PrintStream ps) 的方式重新指定输入和输出流

1.3 练习
从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
进行输入操作，直至当输入“e”或者“exit”时，退出程序。

方式一: Scanner
方式二: System.in(字节流) --> InputStreamRead(转化流) --> BufferedRead的 readLine()
 */
public class OtherStreamTes {

    @Test
    public void test1() {
        BufferedReader br = null;
        try {
            System.out.println("程序开始:");
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true) {
                System.out.print("请输入一个字符串:");
                String date = br.readLine();
                if ("e".equalsIgnoreCase(date) || "exit".equalsIgnoreCase(date) ) {
                    System.out.println("成功推出!");
                    break;
                }
                String s = date.toUpperCase();
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test2() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个字符:");
            String next = sc.next();
            if ("e".equalsIgnoreCase(next) || "exit".equalsIgnoreCase(next)) {
                System.out.println("推出成功");
                break;
            }
            String s = next.toUpperCase();
            System.out.println(s);
        }
    }

    /**
     * 打印流
     */
    @Test
    public void test3() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("text.txt"));
// 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * 数据流
     */
    @Test
    public void test4() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("对象流.txt"));
            dos.writeUTF("张华");
            dos.flush(); // 刷新, 将内存中的数据写到硬盘
            dos.writeInt(12);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dos != null) dos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 只能存储基本数据类型和字符串, 不能存储数据
     *按照写入的数据的顺序, 进行读取数据
     *
     */
    @Test
    public void test5() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("对象流.txt"));
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();
            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("isMale = " + isMale);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
