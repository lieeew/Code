package Day20.study;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/22 - 10 - 22
 * @Description: Day20.study
 */
public class StringTest1 {

    /**
     ** 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量
     *
     * * 只要其中有一个是变量，结果就在堆中
     *
     * * 如果拼接的结果调用intern()方法，返回值就在常量池中
     *
     */
    @Test
    public void test4() {
        String s1 = "javaEEhaboo";
        String s2 = "haboo";
        String s3 = "javaEE" + s2;
        System.out.println(s3 == s1);

        final String s4 = "haboo"; // 可以看成是常量
        String s5 = "javaEE" + s4;
        System.out.println(s5 == s1);

    }

    /**
     * String和 byte[] 之间的转化
     * 编码 : String --> byte[]: 调用String的getBytes()方法
     * 解码:  byte[] --> String : 调用String的构造器
     *
     *
     * 编码 : 字符串---> 字节   由看得懂到看不懂
     * 解码:  字节----> 字符串  由看不懂到看得懂
     *
     * 注意: 解码时要求解码所用的字符集必须与编码一致, 否则会出现乱码!
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes(); // 使用默认的编码格式进行编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = s1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));

        System.out.println("**************");
        String s3 = new String(bytes);
        System.out.println(s3); // 默认格式进行解码
        String s4 = new String(gbks);
        System.out.println(s4); // 编码集和解码集不一致导致乱码!
        String gbk = new String(gbks, "gbk");
        System.out.println(gbk);


    }
    /**
     * String和 char[] 之间的转化
     * String --> char[]  需要调用String 的 toCharArray()
     * char[] --> String  调用String的构造器
     */
    @Test
    public void test2() {
        String s1 = "abc123";
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        char[] char1 = {'h', 'e', 'l', 'l', 'o'};
        String s = new String(char1);
        System.out.println(s);

        // 练习题 String s = "abc123" 转化为 "a21cb3"
        String s2 = "abc123";
        char[] chars1 = s2.toCharArray();

        for (int i = 1; i < 3; i++) {
            char temp = chars1[i];
            chars1[i] = chars1[5 - i];
            chars1[5 - i] = temp;
        }
        System.out.println(new String(chars1));

    }
    /**
     * 复习:
     * String转为基本数据类型, 就调用基本数据类型的parseInt()
     * 基本数据类型转化为String 就调用String的valueOf()
     */
    @Test
    public void test1() {
        String s1 = "12345"; // 在常量池里面
        int i = 12345;
        int ss1 = Integer.parseInt(s1);
        String ss2 = i + " "; // 只要有变量参与都在堆里面
        System.out.println(ss2 == s1); // false
        System.out.println(ss1 + 3);
    }
}
