package Day24.study;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/9 - 11 - 09
 * @Description: Day24.study
 */

import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.*;

/**
 *    一:
 *          |---- Map: 双列数据, 存储kry-- value对的数据 --- 类似于高中的函数: y = f(x)
 *                     |----HashMap:作为Map主要实现类, 线程不安全效率高
 *                          |--- LinkedHashMap: 保证在遍历map元素时， 可以按照添加的顺序实现遍历
 *                          原因: 在原有的HashMap底层结构上,添加了一对指针，指向一前一个和指向后面一个.
 *                          场景: 对于频繁的遍历操作,此类地执行效率高于HashMap
 *
*                      |---TreeMap:按照添加key-value来进行排序, 实现排序遍历. 此时考虑key的自然排序的定制排序
 *                                 底层: 使用红黑数
 *                     |---Hashtable: 作为Map的古老实现类,线程安全,效率低
 *                          |---Properties: 常用来处理配置文件. key和value都是String类型的.
 *
 *
 *
 *         Map底层 : 数组 + 链表 (jdk7.0)
 *                  数组 + 链表 + 红黑数 (jdk8.0)
 *
 *    面试题
 *    ①HashMap的底层源码
 *    ② HashMap和Hashtable的异同?
 *    ③ CurrentHashMap和Hashtable的异同?
 *
 *
 *  二: Map结构分析
 *  Map中的key是无序的,不可重复的,使用set存储所有的key  --> 自定义的类一定要重写 equals()和hashCode() (以HashMap为例)
 *  Map中的value 是无序,可以重复的, 使用Collection存储所有的key.  --> 自定义的类需要重写equals()
 *  一个键值对: key-value构成了一个Entry的对象
 *  Map中的Entry是无序, 不开重复的; 使用set存储所有的entry
 *
 *  三: HashMap底层源码?
 *  jdk7
 *  HashMap map = new HashMap()
 *  在实例化之后, 底层创建的一个长度为16的一维数组Entry[] table
 *  ..........可能已经执行了多次put......
 *  map.put (key1, value1);
 *  首先, 调用key1所在类的hashCode()计算key1的哈希值, 在此哈希值经过某些算法计算之后, 得到Entry数组中的存放位置.
 *      如果这个位置上的数据为空, 此时的key1-value1添加成功 ---- 情况一
 *      如果这个位置上面的数据不为空, (意味着此位置上存在一个或多个数据(以链表的形式存在)), 比较key1和已存在的一个或多个数据的哈希值:
 *              如果key1的哈希值与已存在得哈希值都不相同, 此时key1- value1添加成功 ---情况二
 *              如果key1的哈希值已存在的某一个数据(key2-value2)的哈希值相同, 继续比较. 调用key1所在类的equals(key2)
 *                      如果equals()的返回为false: 此时key1-value1添加成功 --- 情况三
 *                      如果equals()的返回值为true: 使用key1替换key2
 *
 *     补充: 关于情况二和情况三: 此时key1-value1和原来的数据以链表的方式存储
 *
 * 在不断的添加过程中会涉及到扩容,但超出临界值时且要存放的位置非空时,扩容. 默认扩容为原来的两倍,
 * 并把原有的数据复制过来(实际上重新计算哈希值对应的新数组的位置)
 *
 * jdk8相较于jdk7在底层实现类的不同:
 * 1. new HashMap() 底层没有创建一个长度为16的数组
 * 2. jdk8底层的数组是Node()而不是Entry()
 * 3. 首次调用put()方法时, 底层才创建长度为16的数组
 * 4. jdk7底层结构只有:数组 + 链表 ; jdk8底层则有: 数组 + 链表 + 红黑数
 *      当数组的某一个索引位置上的元素以链表的形式存在的数据个数 > 8 且当前数组的长度 >64时,
 *      此时索引位置上的所有数据改为使用红黑数存储;
 *
 * DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 * DEFAULT_LOAD_FACTOR：HashMap的默认加载因子：0.75
 * threshold：扩容的临界值，=容量*填充因子：16 * 0.75 => 12
 * TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树:8
 * MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量:64
 *
 * 四: LinkedHashMap
 *   底层源码:
 *   static class Entry<K,V> extends HashMap.Node<K,V> {
 *          Entry<K,V> before, after;
 *          Entry(int hash, K key, V value, Node<K,V> next) {
 *          super(hash, key, value, next);
 *     }
 * }
 *
 * 五: HashMap中的常用方法:
 * 添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 * 增: put(Object key,Object value)
 * 删:remove(Object key)
 * 改:put(Object key,Object value)
 * 查:get(Object key)
 * 插: 没有
 * 长度: size()
 * 遍历:  keySet() /  values() / entrySet()
 *
 */
public class MapTest {
    /**
     *    Set keySet()：返回所有key构成的Set集合
     *    Collection values()：返回所有value构成的Collection集合
     *    Set entrySet()：返回所有key-value对构成的Set集合
     *
     *   遍历的顺序是一致的, 一一对应的
     */

    @Test
    public void test3() {
        HashMap hashMap = new HashMap();
        hashMap.put("AA", 21);
        hashMap.put("CC", 10086);
        hashMap.put(432, 3423);

        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("************************");

        Collection values = hashMap.values();

        for(Object obj : values) {
            System.out.println(obj);
        }

        System.out.println("***************");

        Set entrySet = hashMap.entrySet();
        Iterator iterator2 = entrySet.iterator();
        // 方法一:
        while (iterator2.hasNext()) {
            Object obj = iterator2.next();
            // entrySet中的对象都是Entry类型的, 可以进行强转
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        // 方法二
        Set keySet = hashMap.keySet();
        Iterator iterator3 = keySet.iterator();
        while (iterator3.hasNext()) {
            Object key = iterator3.next();
            Object Value = hashMap.get(key);
            System.out.println(key + "====" + Value);

        }
    }
    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("AA", 1213);
        map.put("CC", 127);
        map.put("KK", 32112);
        map.put("34", 2344);

        // Object get(Object key)：获取指定key对应的value
        Object o = map.get("34");
        System.out.println(o);

        // boolean containsKey(Object key)：是否包含指定的key
        System.out.println(map.containsKey("AA"));

        // int size()：返回map中key-value对的个对数
        System.out.println(map.size());

        //  boolean isEmpty()：判断当前map是否为空
        System.out.println(map.isEmpty());

        // boolean equals(Object obj)：判断当前map和参数对象obj是否相等
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        System.out.println(hashMap.equals(hashMap));

    }

    @Test
    public void test1() {
        Map map = new HashMap();
        map = new LinkedHashMap();
        // 添加
        map.put("AA", 123);
        map.put("BB", 123);
        map.put("CC", 321);
        map.put("44", 123);
        // 修改
        map.put("AA", 467);
        System.out.println(map);
        // putAll()
        Map map1 = new HashMap();
        map1.put("CC", 321);
        map1.put("DD", 212);
        map1.put("AA", 341221);
        map.putAll(map1);
        System.out.println(map);

        Object value = map.remove("AA"); // 返回value
        System.out.println(map);
        // clear()
        map.clear();
        System.out.println(map.size());

    }
}
