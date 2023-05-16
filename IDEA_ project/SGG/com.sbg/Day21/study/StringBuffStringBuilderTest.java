package Day21.study;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/24 - 10 - 24
 * @Description: Day21.study
 */

import org.junit.Test;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

/**
 * 关于StringBuffer和StringBuilder 的使用
 *
 * String : 不可变的字符序列  底层char[]
 * StringBuffer: 可变的字符序列 线程安全的效率相对较低 底层char[]
 * StringBuilder: 可变的字符序列 jdk5.0新增的, 线程不安全效率较高 底层char[]
 *
 * 源码:
 * String str = new String(); // char[] value = new char[0];
 * String str1 = new String("abc"); char[] value = new char[]{'a', 'b' ,'c'}
 *
 *
 * StringBuffer sb1 = new StringBuffer(); // char[] value = new char[16];
 * StringBuffer sb2 = new StringBuffer("abc"); char[] value = new char[ sb2.length() + 16];
 *
 * 问题一: System.out.println(sb2.length()); 结果为 0
 * 问题二:  扩容问题: 如果添加的数据底层数组装不下 , 那就需要考虑扩容问题
 *  默认状况下: 扩容为原来数组容量的 2 倍 加 2 , 同时将原有数组中的元素复制到新的数组中
 *
 *  指导意义: 开发中数据量大的化可以直接 : new StringBuffer(int capacity)或 new StringBuilder(int capacity);
 */
public class StringBuffStringBuilderTest {

    /**
     *效率对比:
     * StringBuilder > StringBuffer > String
     */

    @Test
    public void test3() {
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }


    /**
     * StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
     * StringBuffer delete(int start,int end)：删除指定位置的内容 左闭右开
     * StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
     * StringBuffer insert(int offset, xxx)：在指定位置插入xxx
     * StringBuffer reverse() ：把当前字符序列逆转
     * public int indexOf(String str) 返回指定字符在字符串中第一次出现处的索引
     * public String substring(int start,int end) 取出来部分
     * public int length()
     * public char charAt(int n )
     * public void setCharAt(int n ,char ch)
     *
     * 总结:
     * 增: append();
     * 删: delete(int start,int end)   左闭右开
     * 改: replace(int start, int end, String str) / setChar(int n, char ch)
     * 查:charAt(int n)
     * 插; insert(int offset, xxx)
     * 长度: length()
     * 遍历: for + charAt() / toString()
     */
    @Test
    public void test2() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.append(1);
        sb1.append('1');
        System.out.println(sb1);
//        sb1.delete(2, 4);
        sb1.replace(2, 4, "hello");
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer("abc11");
        sb2.insert(2, false);
        System.out.println(sb2);
        System.out.println(sb2.length()); // 长度为10

        StringBuffer sb3 = new StringBuffer("abc11");
        sb3.reverse();
        System.out.println(sb3);

        StringBuffer sb4 = new StringBuffer("abc11");
        CharSequence sb5 = sb4.subSequence(1, 3);
        System.out.println(sb4);
        System.out.println(sb5);


    }

    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1.length());
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length()); // 结果是 0
    }
}
