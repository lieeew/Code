package Day25;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/13 - 11 - 13
 * @Description: Day25
 */
public class GenericTest {

// 集合使用泛型之前
    @Test
    public void test1() {
        // 录入学生的成绩
        ArrayList list = new ArrayList();
        list.add(12);
        list.add(98);
        list.add(90);
        list.add(45);
        // 混入不是int类型的
        list.add("Tom");

        // 增强for循环
        for (Object obj : list) {
            // 强转时可能会报错, 会错ClassCastException
            int StudentScore = (int) obj;
            System.out.println(StudentScore);
        }
    }

    // 集合使用泛型之后
    @Test
    public void test2() {
        ArrayList<Integer> list= new ArrayList<Integer>();
        list.add(123);
        list.add(456);
        list.add(89);
        list.add(38);
        // 编译时会报错
//        list.add("Tom");

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    // 集和中使用泛型,以HashMap为例
    @Test
    public void test3() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Tom", 123);
        map.put("jack", 32);
        map.put("jerry", 456);
        map.put("Mick", 89);
        // 泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entry.iterator();

        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> next = entryIterator.next();
            System.out.println(next);
        }
    }

}
