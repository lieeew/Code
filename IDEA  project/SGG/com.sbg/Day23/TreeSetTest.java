package Day23;

import org.junit.Test;

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
 *    向TreeSet中添加的数据, 要求是相同类的对象
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
}
