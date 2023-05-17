package Day23;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/5 - 11 - 05
 * @Description: Day23
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *     |------ Collection接口 : 单例集合, 用来存储一个一个对象
 *          |-----List接口: 存储无序的, 可以重复的数组 --> "动态"数组
 *                 |-->ArrayList 作为List接口的主要实现类 线程不安全的, 效率高 底层使用Object[] elementData存储
 *                 |-->LinkedList 底层使用双向链表存储, 对于频繁的插入或删除,效率会比ArrayList效率高
 *                 |-->Vector  作为List接口的古老实现类  线程安全的, 效率不高 底层使用Object[] elementData存储
 *
 *
 *        1.0 ArraysList源码分析
 *
 *       jdk7.0
 *       ArrayList list = new ArrayList();  // 底层创建了一个长度为10的 Object[] elementData数组
 *       list.add(10);  // 底层 elementData[0] = new Integer(10);
 *       .......
 *       list.add(11); // 如果此次添加导致低沉elementData长度不够, 那么就会扩容到原来的1.5倍, 同时将原有的数据复制到新建的数组
 *
 *       启发: 在开发, 如果明确需要很长的容量, 可以提前指定容量, 避免重复扩容影响效率
 *       ArrayList list = new ArrayList(int capacity);来创建
 *
 *       jdk8.0
 *
 *      中ArrayList的变化
 *      ArrayList list = new ArrayList();  // 底层创建了一个长度为0的 Object[] elementData数组 {}
 *
 *      list.add(123); // 第一次调用add方法, 底层才创建一个长度为10的数组
 *
 *      小结: jdk7的创建方式, 类似于单例设计模式中的饿汉式
 *           jdk8的创建方式  类似于单例设计模式中的懒汉式
 *
        2.0 LinkedList源码分析
        linkedList list = new LinkList（） 内部声明了Node的first 和 last属性, 此时默认值为null
        list.add(123); // 将123封装的Node对象之中
        其中LinkedList中Node的定义体现了双向链表

        3.0 jdk7.0和jdk8.0 的vector源码分许
        vector底层都是创键了,一个长度为10的Object[]数组, 扩容默认为2倍
 *
 * 面试题: ArraysList, LinkedList, Vector 三者的异同点
 *  相同点 : 都实现了List接口, 都可以存储: 有序 可重复的数组
 *  不同点 : 看上面
 *
 *  重载不覆盖
 *  重写覆盖
 */
public class CollectionListTest {
    /**
     * void add(int index, Object ele):在index位置插入ele元素
     * boolean addAll(int index, Collection eles):从index位置开始将else中的所有元素添加进来
     * Object get(int index):获取指定index位置的元素
     * int indexOf(Object obj):返回obj在集合中首次出现的位置
     * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
     * Object remove(int index):移除指定index位置的元素，并返回此元素
     * Object set(int index, Object ele):设置指定index位置的元素为ele
     * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
     * 位置的子集合
     *
     * 增 add()
     * 删 remove(int index) / remove(Object obj)
     * 改 set(int index, Object ele)
     * 查 get(int index)
     * 插 add (int index, Object ele)
     * 长度 size()
     * 遍历 ① Iterator 迭代器遍历
     *     ② 增强for循环
     *     ③ 普通for循环
     *
     */

    @Test
    public void test1() {
       ArrayList list = new ArrayList();
        list.add("AA");
        list.add(new Person(23, "Tom"));
        list.add("AA");
        list.add(123);
        System.out.println(list);

        // void add(int index, Object ele):在index位置插入ele元素
        list.add(1, new Person(12, "Jack"));
        System.out.println(list);

        // boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素加入进来
        List integers = Arrays.asList(1, 2, 33);
        list.add(2, integers);
        System.out.println(list);
        System.out.println(list.size()); // 如果list调用add那么, 结果为5

    }
    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add("AA");
        list.add(new Person(23, "Tom"));
        list.add("AA");
        list.add(123);
        list.add(323);
        System.out.println(list);

        // int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置, 找不到返回-1
        System.out.println(list.indexOf(123)); //  找到了3
        System.out.println(list.indexOf(321)); //  没找到-1
        System.out.println(list.lastIndexOf(323)); // 从后往前找


        // Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));

        // Object remove(int index):移除指定index位置的元素，并返回此元素
        Object remove = list.remove(2);
        System.out.println(remove);
        System.out.println(list);

        // Object set(int index, Object ele):设置指定index位置的元素为ele,返回被修改的值
        Object qiu = list.set(1, "QIU");
        System.out.println(qiu);
        System.out.println(list);

        // List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex左闭右开的List, 不会修改原来的list
        List list1 = list.subList(0, 3);
        System.out.println(list1);

    }

    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add("AA");
        list.add(new Person(23, "Tom"));
        list.add("AA");
        list.add(123);
        list.add(323);

        // 方式一
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("*******************");

        // 方式二
        for(Object obj : list) {
            System.out.println(obj);
        }
        System.out.println("*******************");

        // 方式三
        for (int i = 0; i < list.size() ;i++) {
            System.out.println(list.get(i));
        }
    }
}
