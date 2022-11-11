package Day23;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/8 - 11 - 08
 * @Description: Day23
 */

/**
 *   |------ Collection接口 : 单例集合, 用来存储一个一个对象
 *             |-----List接口: 存储无序的, 可以重复的数组 --> "动态"数组
 *                   |---> ArrayList，LinkedList，Vector
 *             |-----Set 接口: 存储无序的, 不开重复的数组 --> 高中讲的"集合"
 *                   |---> HashSet，LinkedHashSet,TreeSet
 *
 *    1.向TreeSet中添加的数据, 要求是相同类的对象
 *    2.两种排序方式: 自然排序 和 定制排序
 *    3. 自然排序中, 比较两个对象是否为相同标准为: CompareTo()返回0, 不再是equals().
 *    4. 定制排序中, 比较两个对象是否为相同标准为: Compare()返回0, 不再是equals().
 */
public class TreeSetTest {

    @Test
    public void test() {
        TreeSet set = new TreeSet();
        // 举例一:
//        set.add(123);
//        set.add(456);
//        set.add(789);

        // 举例二: 按照ABCD...排序
//        set.add("A");
//        set.add("G");
//        set.add("E");
//        set.add("C");

        set.add(new User(new String("Tom"), 12));
        set.add(new User("Jack", 15));
        set.add(new User("Mick", 10));
        set.add(new User(new String("Tom"), 99));

        System.out.println(set);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        // 定制排序
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User) {
                    User user1 = (User) o1;
                    User user2 = (User) o2;

                    return Integer.compare(user1.getAge(), user2.getAge());
                }
                throw new RuntimeException("请输入正确的类型");
            }
        };
        TreeSet set = new TreeSet(com);
        set.add(new User("Tom", 12));
        set.add(new User("Jack", 15));
        set.add(new User("Qiu", 10));
        set.add(new User("Micks", 10));

        System.out.println(set);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
