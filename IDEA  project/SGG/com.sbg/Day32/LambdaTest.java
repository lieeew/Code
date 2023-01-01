package Day32;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/29 - 12 - 29
 * @Description: Day32
 * Lambda表达式
 * 1. 举例 : (o1, o2) -> Integer.compare(o1, o2);
 * 2. 格式
 *      -> :lambda操作符
 *      ->左边 : Lambda形参列表, 就是接口中抽象方法的形参列表
 *      ->右边 : Lambda体, 就是抽象方法的方法体
 *
 * 3. 具体使用6种情况
 *  第一种 : 没有形参列表
 *
 * 4. Lambda的本质: 作为接口实现类的实例(接口实现类的具体对象)
 */
public class LambdaTest {

    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        // Lambda表示式写法
        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator2.compare(12, 32));
        // 方法引用
        Comparator<Integer> comparator3 = Integer::compare;

    }

    @Test
    public void test2() {
        // 没有形参列表
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("笑死了");
            }
        };
        runnable.run();

        Runnable runnable1 = () -> System.out.println("笑死了");
        runnable1.run();


        // 有参数 无返回值
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("谎言和誓言的区别是什么?");

        Consumer<String> consumer2 = s -> {
            System.out.println(s);
        };
        consumer2.accept("一个是说的人当真了, 一个是做的人当真了");
        //  *************
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1, o2);
            }
        };

        Comparator<Integer> comparator1 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };


    }
}
