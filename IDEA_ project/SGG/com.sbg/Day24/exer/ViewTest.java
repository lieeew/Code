package Day24.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/9 - 11 - 09
 * @Description: Day24
 */
public class ViewTest {

    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }
    /**
     * 有水平
     * 首先,根据， 底层根据id 1001和 name AA计算出一个hash值a根据hash值来找出在底层数组中的位置
     * 然能后吧name 中的"AA"变为"CC"此时在计算后hash值就变为b, 此时p1的属性变为id 1001 name " CC"按照计算hash值为b后的位置并不是这个位置
     * 所以在调用remove()方法是没有找到hash值为b对因位置的元素, 所以没有删除成功
     */
    @Test
    public void test1() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);

    }

}
