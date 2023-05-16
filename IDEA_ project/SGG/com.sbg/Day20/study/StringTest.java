package Day20.study;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/20 - 10 - 20
 * @Description: Day20.study
 */

/**
 * String字符串, 使用双引号来表示
 *  1. String声明为final , 不可以改变和继承
 *  2. String 实现类Serializable接口: 表示字符串支持序列化
 *            实现来Comparable接口 : 表示String可以比较大小
 *  3. String内部定义了 final char[] value 用于存储字符创数据
 *  4. String代表一个不可变的字符序列
 *
 *  5. 字符常量的方式(区别于new)给一个字符串赋值, 此时字符创声明在字符创常量池中
 *  6. 字符创常量池中不会存储相同内容的字符串
 *
 */
public class StringTest {
    /**
     *  1. 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量
     *  2. 只要其中有一个是变量，结果就在堆中
     *  3. 如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test3() {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = s1 + "world";
        String s6 = "hello" + s2;
        String s7 = s1 + s2;
        String s8 = (s1 + s2).intern();

        System.out.println(s3 == s4); // true
        System.out.println(s5 == s3); // false
        System.out.println(s6 == s3); // false
        System.out.println(s7 == s3); // false
        System.out.println(s8 == s3); // true
    }

    @Test
    public void test2() {

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);

        Person p1 = new Person("tom", 15);
        Person p2 = new Person("tom", 15);
        System.out.println(p1.name.equals(p2.name)); // true
        System.out.println(p1.name == p2.name); // true
    }

    @Test
    public void Test1 () {
        String s1 = "abc"; // 字面量
        String s2 = "abc";
        s1 = "hello";
        System.out.println(s1 == s2); // 比较地址值
    }
}
