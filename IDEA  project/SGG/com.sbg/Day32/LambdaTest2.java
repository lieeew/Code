package Day32;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/30 - 12 - 30
 * @Description: Day32
 * java 内置的4大函数接口
 * 消费型接口 Consumer<T>    void accept (T t)
 * 供给形接口 Supplier<T>    T get()
 * 函数形接口 Function<T>    R apply (T t)
 * 断定形接口 Predicate<T>   boolean test(T t)
 */
public class LambdaTest2 {

    @Test
    public void test1() {
        happyTime(500, new Consumer<Integer>() {
            @Override
            public void accept(Integer aMoney) {
                System.out.println("不如去天上人间, 买瓶" + aMoney  + "矿泉水");
            }
        });


        System.out.println("*************");
        happyTime(1000, money -> System.out.println("不如去天上人间, 买瓶" + money  + "矿泉水"));

    }

    public void happyTime(int money, @NotNull Consumer<Integer> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "天津", "普京", "精华", "经理", "汴京");
        List<String> list1 = filterList(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        for (String str : list1) {
            System.out.println(str);
        }

        System.out.println("******************************");

        List<String> list2 = filterList(list, s -> s.contains("京"));
        System.out.println(list2);

    }

    public List<String> filterList(@NotNull List<String> list, Predicate<String> pro) {
        ArrayList<String> filterLists = new ArrayList<>();

        for (String str : list) {
            if (pro.test(str)) {
                filterLists.add(str);
            }
        }

        return filterLists;
    }
}
