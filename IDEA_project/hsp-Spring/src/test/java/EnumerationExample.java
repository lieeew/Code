import java.util.Enumeration;
import java.util.Hashtable;

/**
 * ClassName: EnumerationExample
 * Package: PACKAGE_NAME
 *
 * @Author: leikooo
 * @Creat: 2023/5/30 - 6:38
 * @Description:
 */
public class EnumerationExample {
    public static void main(String[] args) {
        Hashtable<String, Integer> numbers = new Hashtable<>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);

        // 在开始遍历 Enumeration 时，指针将位于第一个元素的前面，因此第一次调用 nextElement() 方法将返回第一个元素。
        // 接下来，每次调用 nextElement() 方法都将返回下一个元素，直到遍历完所有元素为止
        Enumeration<String> keys = numbers.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            int value = numbers.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}