package Day23;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/6 - 11 - 06
 * @Description: Day23
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * |------ Collection接口 : 单例集合, 用来存储一个一个对象
 *
 *          |-----Set 接口: 存储无序的, 不开重复的数组 --> 高中讲的"集合"
 *                 |--> HashSet :set接口的主要实现类, 线程不安全, 可以存储null值
 *                      |-->LinkedHashSet :作为HashSet的子类 可以按照添加的顺序进行变量
 *                 |-->TreeSet : 使用红黑数组, 添加的元素必须是同一类中对象, 可以按照对象的某些属性进行排序

 *    1. set中没有定义额外的方法, 都是Collection中定义的
 *
 *    2. 要求：
 *          向set中添加的数据，一定要重写hashCode（）和 equals（）方法 即 相同的对象一定要有相同的哈希值
 *          重写两方法的小技巧: 对象中用作equals()方法比较Field, 都应该用来计算hashCode值;
 *
 */
public class SetTest {
    /**
     * set集合存储无序的, 不开重复的元素
     * 一:
     * 以HashSet为例
     * 1. 无序性 : 不等于随机性. 存储的数据在底层数组中并非按照索引顺序添加的, 而是根据数据的哈希值确定的
     *
     * 2. 不开重复性 保证元素添加的元素按照equals()来判断, 不能返回true; 即相同的元素只能添加一个
     * 二:
     * 以HashSet为例
     *  我们向HashSet中添加a, 首先调用元素啊所在类的hashCode()方法, 计算元素a的哈希值, 通果过默写算法把哈希值转化为HashSet底层数组中的存放位置(即为索引位置)
     *  判断此位置上是否有元素:
     *          若没有元素, 则添加成功;   ---> 情况一
     *          若此位置有其他元素b(或以链表形式存在多个元素), 则比较元素a与元素b的hash值:
     *                  若hash值不相同, 则元素a添加成功  --->情况二
     *                  若hash值相同, 进而判断a类中的equals()方法,看equals()的返回值
     *                          如果返回值为true, 那么添加失败
     *                          如果返回值为false, 那么添加成功  --->情况三
     *
*            对于,情况二和情况三来说, 元素a与已存在指定索引位置上的数据以链表方式存储
     *       对于以链表形式存放的顺序:
     *                 jdk7.0: 元素a放到数组中, 指向原来的元素
     *                jdk8.0: 原来的元素在数组中指向元素a
*                总结： 7上8下
     *   HashSet底层是数组 + 链表

     *     ctrl + F12 中的当前类的方法
     */
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(123);
        set.add(456);
        set.add(new String("Tom"));
        set.add(new Person(23, "LiHua"));
        set.add(123);
        set.add(new User("Tom", 12));
        set.add(new User("Tom", 12));

        System.out.println(set);
    }


    /**
     *LinkedHashSet作为HashSet的子类, 再添加数据时,每个数据还维护两个引用记录
     * 前一个数据和后一个数据.
     * 优点: 对于频繁的遍历操作, LinkedHasHSet效率高于HashSet
     */

    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(new String("Tom"));
        set.add(new Person(23, "LiHua"));
        set.add(123);
        set.add(new User("Tom", 12));
        set.add(new User("Tom", 12));

        System.out.println(set);

    }
}
