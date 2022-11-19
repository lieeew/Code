package Day26;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/16 - 11 - 16
 * @Description: Day26
 */
public class FanxingText {

    @Test
    public void test1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("10001", 12);
        map.put("10002", 14);
        map.put("10003", 18);
        map.put("10004", 20);
        map.put("10005", 30);

        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        Set<String> strings = map.keySet();
        for (String str : strings) {
            System.out.println(str);
        }

        System.out.println();

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entries.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
