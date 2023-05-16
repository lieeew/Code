package Day24.study;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/10 - 11 - 10
 * @Description: Day24.study
 */
public class TreeMapTest {

    // 自然排序
    @Test
    public void test1() {
        Map map = new TreeMap();
        Person p1 = new Person("Tom", 212);
        Person p2 = new Person("Jcry", 212);
        Person p3 = new Person("Jack", 212);
        Person p4 = new Person("Jack", 300);

        map.put(p1, 90);
        map.put(p2, 79);
        map.put(p3, 100);
        map.put(p4, 20);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry e = (Map.Entry) obj;
            System.out.println(e.getKey() + "-->" + e.getValue());
        }
    }

    // 定制排序
    @Test
    public void test2() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getId(), p2.getId());
                }
                throw new RuntimeException("请输入正确的类型");
            }
        };


        Map map = new TreeMap(comparator);
        Person p1 = new Person("Tom", 212);
        Person p2 = new Person("Jcry", 212);
        Person p3 = new Person("Jack", 212);
        Person p4 = new Person("Jack", 300);

        map.put(p1, 90);
        map.put(p2, 79);
        map.put(p3, 100);
        map.put(p4, 20);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry e = (Map.Entry) obj;
            System.out.println(e.getKey() + "-->" + e.getValue());
        }
    }
}
