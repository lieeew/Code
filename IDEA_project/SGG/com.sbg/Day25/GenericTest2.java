package Day25;

import org.junit.Test;

import java.util.List;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/14 - 11 - 14
 * @Description: Day25
 */

/**
 *  有限制条件的
 *   ? extends A
 *         G<? extends A> 可以作为G<A> 和 G<B> 的父类, 其中B是A的子类, 这个相当于<=, 不能添加数据
*    ? super A
 *         G<? super A> 可以作为G<A> 和 G<B> 的父类, 其中B是A的父类, 这个相当于>=, 可以添加数据, 符合多态(子类赋给父类)
 */
public class GenericTest2 {

    @Test
    public void test1() {
        // 可以看成小于等于<=
        List<? extends Person> list1 = null;
        // 可以理解为>=
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

//        list1.add(123); 报错
        list2.add(new Person()); // 多态
    }
}
