package Day23;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/4 - 11 - 04
 * @Description: Day23
 */

/**
 * 集合元素遍历操作iterator, 主要是用来遍历Collection ,而Map不用iterator来遍历
 */
public class IteratorTest {
    @Test
    public void test4() {
        double sin = Math.sin(1.2);
        System.out.println(sin);
    }
    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person(23, "Tom"));
        coll.add(new String("Hello"));
        Iterator iterator = coll.iterator();

        while (iterator.hasNext()) {
            Object next = iterator.next();
            if ("Tom".equals(next)) {
                iterator.remove();
            }
        }
        // 需要重置指针
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person(23, "Tom"));
        coll.add(new String("Hello"));
        Iterator iterator = coll.iterator();

        // 错误写法一
        /*if (iterator.next() != null) {
            System.out.println(iterator.next());
        }*/

        // 错误写法二 匿名对象
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next()); // 会不停的输出第一个值: 123
        }
    }
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person(23, "Tom"));
        coll.add(new String("Hello"));
        Iterator iterator = coll.iterator();

        // next()方法, 可以输出对象的内容
        /*System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        // 超过了size()就会报错 NoSuchElementException
        // System.out.println(iterator.next());*/

        // 方式二: 不推荐
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }

        // 方式三, 推荐写法 iterator不是容器, 元素还在原来的集合中
        // hasNext() 判断指针指向的下一个位置的情况
        // next() 把指针下移, 然后输出
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
