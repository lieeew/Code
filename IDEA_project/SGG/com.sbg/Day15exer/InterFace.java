package Day15exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/18 - 09 - 18
 * @Description: Day15exer
 */
public interface InterFace {

    public static void method1 () {
        System.out.println("Compare A 北京");
    }

    public default void method2 () {
        System.out.println("Compare A 上海");

    }
    default void method3 () {
        System.out.println("Compare A 上海");
    }

}
