package Day24.study;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/11 - 11 - 11
 * @Description: Day24.study
 */

import org.junit.Test;

import java.util.*;

/**
 * Collections 工具类,操作Collection 和 Map
 *
 * 面试题 :
 *      Collection 和 Collections 的区别?
 *
 *
 *reverse(List)：反转 List 中元素的顺序
 * shuffle(List)：对 List 集合元素进行随机排序
 * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 *
 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
 * 给定集合中的最大元素
 * Object min(Collection)
 * Object min(Collection，Comparator)
 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * void copy(List dest,List src)：将src中的内容复制到dest中
 * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换
 * List 对象的所有旧值
 */
public class CollectionsTest {

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(675);
        list.add(-78);
        list.add(0);

        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
        // shuffle() 随机排序
        Collections.shuffle(list);
        System.out.println(list);
        // sort(List) 从小到大
        Collections.sort(list);
        System.out.println(list);
        // swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        Collections.swap(list, 0, 1);
        System.out.println(list);

    }
    @Test
    public void test2() {
        // sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
        List list = new ArrayList();

        Person p1 = new Person("Tom", 17);
        Person p2 = new Person("Jack", 17);
        Person p3 = new Person("Jack", 18);
        Person p4 = new Person("Marry", 20);
        Person p5 = new Person("Coral", 17);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    int i = p1.getName().compareTo(p2.getName());
                    if (i != 0) {
                        return -i;
                    }
                    return -Integer.compare(p1.getId(), p2.getId());
                }
                throw new RuntimeException("请输入正确的类型");
            }
        };

        Collections.sort(list, com);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     *  Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
     *  Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
     *  给定集合中的最大元素
     *  Object min(Collection)
     *  Object min(Collection，Comparator)
     *  int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
     *  void copy(List dest,List src)：将src中的内容复制到dest中
     *   boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
     */
    @Test
    public void test3() {
        Set set = new HashSet();
        set.add(123);
        set.add(432);
        set.add(-283);
        set.add(0);

        Comparable max = Collections.max(set);
        System.out.println(max);

        Comparable min = Collections.min(set);
        System.out.println(min);

        System.out.println("*************************");


        Set list= new HashSet();

        Person p1 = new Person("Tom", 17);
        Person p2 = new Person("Jack", 17);
        Person p3 = new Person("Jack", 18);
        Person p4 = new Person("Marry", 20);
        Person p5 = new Person("Coral", 0);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    // 按照id的大小排序
                    return Integer.compare(((Person) o1).getId(), ((Person) o2).getId());
                }
                throw new RuntimeException("请输入正确的数据类型");
            }
        };

        Object max1 = Collections.max(list, comparator);
        System.out.println(max1);


        Object min1 = Collections.min(list, comparator);
        System.out.println(min1);


    }

    @Test
    public void test4() {
        List list = new ArrayList();
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(456);
        list.add(675);
        list.add(-78);
        list.add(0);

        System.out.println(list);
        int frequency = Collections.frequency(list, 123);
        System.out.println(frequency); // 3

        // copy() 错误的
//        List dest = new ArrayList();
//        Collections.copy(dest, list); // IndexOutOfBoundsException: Source does not fit in dest
//        System.out.println(dest);
        // 正确的写法
        List objects = Arrays.asList(new Object[list.size()]);// 造一个和list长度一样的Object[list.size]长度的数组
        Collections.copy(objects, list);
        System.out.println(objects);

        // 返回线程安全的对象
        List list1 = Collections.synchronizedList(list);

    }

}
