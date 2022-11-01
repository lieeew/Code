package Day22.study;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

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
 *定制排序
 *   当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
 *   或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那
 *   么可以考虑使用 Comparator 的对象来排序，
 *
 * Comparable 和 Comparator 之间的区别
 * Comparable 一旦指定Comparable的实现类都可以记性比较
 * Comparator 只能实行一次 (需要造匿名实现类)
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

        Arrays.sort(str, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return - s1.compareTo(s2); // 按照顺序由大到小
                }
                throw new RuntimeException("请输入String类型的变量");
            }
        });

        System.out.println(Arrays.toString(str));
    }


    @Test
    public void test3() {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("lenovo", 250);
        goods[1] = new Goods("Xiaomi", 20);
        goods[2] = new Goods("BUAWEI", 300);
        goods[3] = new Goods("Apple", 2000);
        goods[4] = new Goods("OPPO", 2000);

        Arrays.sort(goods, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                // 先按照名称排序, 在按照价格排序
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods goods1 = (Goods) o1;
                    Goods goods2 = (Goods) o2;
                    if (goods1.getName().compareTo(goods2.getName()) != 0) {
                        return goods1.getName().compareTo(goods2.getName());
                    } else {
                        return -Double.compare(goods1.getPrice(), goods2.getPrice());
                    }
                }
                throw new RuntimeException("传入正确的数据");
            }
        });

        System.out.println(Arrays.toString(goods));

    }
}
