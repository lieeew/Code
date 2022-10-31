package Day22.study;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/30 - 10 - 30
 * @Description: Day22.study
 */

/**
 * java比较器
 * 正常情况下, java中的对象只能进行 == 或 != 不能进行 > 或 < 的比较,但是在开发中有诉求, 可以痛过实现接口的方式
 * 执行 借口: Comparable 和  Comparator
 *
 *  像String，包装类,重写了CompareTo() 方法 自然排序
 * compareTo(Object obj) 方法，两个对象即
 * 通过 compareTo(Object obj) 方法的返回值来比较大小。
 * 如果当前对象this大于形参对象obj，则返回正整数，
 * 如果当前对象this小于形参对象obj，则返回负整数，
 * 如果当前对象this等于形参对象obj，则返回零。
 *
 */
public class CompareTest {

    @Test
    public void test1() {
        String[] str = new String[]{"AA", "OO", "DD", "GG", "HH", "BB"};

        Arrays.sort(str);
        System.out.println(Arrays.toString(str));


    }


    // 自然排序
    @Test
    public void test2() {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("lenovo", 250);
        goods[1] = new Goods("Xiaomi", 20);
        goods[2] = new Goods("HUAWEI", 300);
        goods[3] = new Goods("Apple", 2000);
        goods[4] = new Goods("OPPO", 2000);

        Arrays.sort(goods);

        System.out.println(Arrays.toString(goods));
    }

    /**
     * 定制排序
     *  当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
     *  或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那
     *  么可以考虑使用 Comparator 的对象来排序，
     */

    @Test
    public void comparator() {
        String[] str = {"GG", "BB", "KK", "WW", "PP"};


    }
}
