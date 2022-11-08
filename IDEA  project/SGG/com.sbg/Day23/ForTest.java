package Day23;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/5 - 11 - 05
 * @Description: Day23
 */
public class ForTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new Person(23, "Tom"));

        // 增强for循环
        // 格式: for(被遍历元素的类型 自变量的命名 : 被遍历变量的名字)
        for(Object obj: coll) {
            System.out.println(obj);
        }

        int[] ints = {1, 34, 56};
        for(int i: ints) {
            System.out.println(i);
        }

        // 面试题
        String[] strings = {"MM", "MM", "MM"};

        // 方式一: 普通for
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "GG";
        }

        // 方式二: foreach
        for (String s: strings) { // 这个是把strings的每一个元素赋值给String类型的s, 然后把s修改, 并没有修改strings里面的元素
            s = "KK";
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }
}
