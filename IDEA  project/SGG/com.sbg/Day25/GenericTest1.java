package Day25;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/13 - 11 - 13
 * @Description: Day25
 */

import org.junit.Test;

/**
 * 关于自定义泛型类, 和自定义泛型接口
 * 如果自定义的泛型类, 在实例化是没有指定类的泛型, 那么默认为java.long.Object
 * 要求:如果大家定义的类中带泛型, 那么实例化是建议指定泛型
 */
public class GenericTest1 {

    @Test
    public void test1() {
        // 有泛型尽量使用泛型
        Order o1 = new Order();
        o1.setOrderT(123);

        Order<String> o2 = new Order<>();
        o2.setOrderT("Tom");
    }
}
