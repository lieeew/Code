package Day25;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/14 - 11 - 14
 * @Description: Day25
 */

/**
 * 1. 泛型继承相关
 *
 * 2. 通配符的使用
 *    通配符 : ?
 */
public class GenericTest {
/*
1. 泛型继承相关

类A和类B是子父类的关系, 但是G<A>和 G<B>不是子父类的关系 是并列关系. G<?> 是A和B的公共父类
类A和类B是子父类的关系, 那么A<G> 和 B<G>是子父类的关系;

       List<Integer> list1 = new ArraysList<Integer>();
       List<Object> list2 = null;
       list2 = list1;

可以通过反推发证明
如果可以添加成功: 在底层创建了List1数组, list2的引用指向list1在推中的对象,
如果list2.add("Tom")那么就会出现异常

 */
    @Test
    public void test1() {
        Object obj = null;
        String str1 = null;
        obj = str1; // 多态

        String[] str2 = null;
        Object[] obj2 = null;
        obj2 = str2; //多态

        List<Integer> list1 = null;
        List<Object> list2 = null;
//        list2 = list1; // 报错
        show(list1);
        show1(list2);


    }

    public void show(List<Integer> list) {
        System.out.println("Integer");
    }

    public void show1(List<Object> list) {
        System.out.println("Object");
    }


    @Test
    public void test2() {
        List<String> list1 = null;
        ArrayList<String> list2 = null;
        AbstractList<String> list3 = null;

        list1 = list2;
        list1 = list3;

    }

    /*
    通配符 : ?
    相当于父类
     */
    @Test
    public void test3() {
        List<Integer> list1 = Arrays.asList(12, 45, 90);
        List<String> list2 = Arrays.asList("Tom", "Jack", "Mam");

        List<?> list = null;

        Ergodic(list1);
        System.out.println("***************");
        Ergodic(list2);

        list = list1;

        // 只允许添加null, 其他的不予许添加
//        list.add(null);
        // 允许获取数据,类型是Object
        Object o = list.get(0);
        System.out.println(o);
    }

        public void Ergodic(List<?> list) {
            Iterator<?> iterator = list.iterator();
            while (iterator.hasNext()) {
                Object next = iterator.next();
                System.out.println(next);
            }
    }
}
