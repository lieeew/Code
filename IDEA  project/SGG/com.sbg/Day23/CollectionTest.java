package Day23;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/3 - 11 - 03
 * @Description: Day23
 */

import org.junit.Test;

import java.util.*;

/**
 *     |------ Collection接口 : 单例集合, 用来存储一个一个对象
 *           |-----List接口: 存储无序的, 可以重复的数组 --> "动态"数组
 *                 |---> ArrayList，LinkedList，Vector
 *           |-----Set 接口: 存储无序的, 不开重复的数组 --> 高中讲的"集合"
 *                 |---> HashSet，LinkedHashSet,TreeSet
 *
 *     |-------Map接口: 双列集合, 用来存储一对(key-value)一对数据 ---> 高中函数: y = f(x)
 *     key相当于x， value相当于y, 一个key可以对应多个value, 但是一个key不能对应多个value
 *              |----> HashMap, LinkedHashMap, TreeMap, HashTable, Properties
 */
public class CollectionTest {

    @Test
    public void test6() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person(23, "Tom"));
        coll.add(new String("Hello"));

        // hashCode() 获取当前对象的哈希值
        System.out.println(coll.hashCode());

        // 集合 --> 数组 toArray()
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i] + ", ");
        }

        // (扩展)数组  --> 集合
        List<String> strings = Arrays.asList("AA", "BB", "CC");
        System.out.println(strings);
        List<int[]> ints = Arrays.asList(new int[]{1, 2, 34});
        System.out.println(ints); // [[I@3d82c5f3] 这个被当成一个整体进行使用
        System.out.println(ints.size());
    }

    @Test
    public void test5() {
        Collection coll = new ArrayList(); //这个是有序集合, equals()对顺序有要求
        coll.add(123);
        coll.add(456);
        coll.add(new Person(12, "Bob"));
        coll.add(new String("lihua"));
        System.out.println(coll);

        Collection coll1 = Arrays.asList(123, 456, 789);

        // equals(Object obj) 要想返回ture, 要判断当前元素和形参集合需要一样(对于有序和无序集合要求不一样)
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person(12, "Bob"));
        coll.add(new String("lihua"));

        Collection coll1 = Arrays.asList(123, 456, 789);

        //retainAll()  求交集, 把交集的值给了调用此方法的对象
        coll.retainAll(coll1);
        System.out.println(coll);

    }

    @Test
    public void test3() {
        // remove(Object o) 从当前集合中移除元素o
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person(12, "Bob"));
        coll.add(new String("lihua"));

        System.out.println(coll.remove(123));
        System.out.println(coll);

        System.out.println(coll.remove(new Person(23, "bob")));
        System.out.println(coll);

        // removeAll(Object obj) 从当前集合中移除所以的obj元素, 相当于移除两个集合的交集
        Collection coll1 = Arrays.asList(123, 456, 789);
        System.out.println(coll.removeAll(coll1));
        System.out.println(coll);


    }
    /**
     * 向Collection接口的实现类中添加obj时, 要求obj所在的类需要重写equals()
     */
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add("ABC");
        Person p = new Person(12, "Mike");
        coll.add(p);
        System.out.println(coll.contains(p));

        coll.add(new Person(12,"bob"));
        System.out.println(coll.contains(new Person(12, "bob")));

        coll.add(new String("Tom"));
        System.out.println(coll.contains(new String("Tom"))); // String重写了equals()方法

        // containsAll(Collection coll)  判断形参coll是否全部存在与当前对象
        // 方式一:
//        Collection coll2 = new ArrayList();
//        coll2.add("ABC");
//        coll2.add("www");
        // 方式二:
        Collection coll2 = Arrays.asList(123, 456); // 多态
        System.out.println(coll.containsAll(coll2)); // false

    }
    @Test
    public void test1() {
        Collection coll = new ArrayList();

        // add(Object e) 将e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123); // 自动装箱
        coll.add(new Date());

        // size() 添加元素的个数
        System.out.println(coll.size());

        // addAll()
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll1.addAll(coll);
        System.out.println(coll1.toString()); // 这个是经过重写过得方法

        // isEmpty() 是否为空
        System.out.println(coll.isEmpty());

        // clear() 清空对象,但是不是null
        coll.clear();
        System.out.println(coll.isEmpty());
        System.out.println(coll);// []


    }
}
