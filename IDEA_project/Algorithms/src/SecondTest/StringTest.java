package SecondTest;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/4 - 11 - 04
 * @Description: SecondTest
 */
public class StringTest {

    @Test
    public void test6() {
        Collection coll = new ArrayList(); // 多态
        coll.add(123);
        coll.add(456);
        coll.add(789);
        coll.add(new String("你好"));

        Iterator iterator = coll.iterator();
        // 推荐使用的方法
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(789);
        coll.add(new String("lihua"));
        coll.add(new Person(23, "Mike"));

        // Coleection --> Object[]
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        // Object[] --> Collection
        List integers = Arrays.asList(new int[] {12, 34, 56}); //不会输出 12, 34, 56因为这个in[]被看成一个整体
        System.out.println(integers);

    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
//        coll.add(789);
//        coll.add(new String("lihua"));
        coll.add(new Person(23, "Mike"));

        List coll1 = Arrays.asList(123, 456, new Person(23, "Mike"));

        System.out.println(coll.equals(coll1));
        System.out.println(coll.isEmpty());
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(789);
        coll.add(new String("lihua"));
        coll.add(new Person(23, "Mike"));

        List integers = Arrays.asList(123, 456, new Person(23, "Mike"));

        System.out.println(coll.contains(new Person(23, "Mike")));

        System.out.println(coll.containsAll(integers));
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(789);
        coll.add(new String("lihua"));
        coll.add(new Person(23, "Mike"));

        List<Integer> integers = Arrays.asList(123, 456);

//        System.out.println(coll.remove(123));
//        System.out.println(coll);
        System.out.println(coll.removeAll(integers)); // 把交集给删除, 没有返回值会更改调用的对象
        System.out.println(coll);

    }
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(789);
        coll.add(new String("lihua"));
        coll.add(new Person(23, "Mike"));
        System.out.println(coll);
        // addAll(Object obj) 把obj赋值调用的对象
        Collection coll1 = new ArrayList();
        System.out.println(coll1.addAll(coll));
        System.out.println(coll1);

        // clear()
        coll.clear();
        System.out.println(coll.size());

    }
}
