package Day14exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/8 - 09 - 08
 * @Description: Day14exer
 */

/**
 *
 * 饿汉式 : 缺点 对象记载时间过长
 *         优点 线程安全
 * 懒汉式: 优点 延迟创建对象
 *
 */
public class SingletonTest2 {
    public static void main(String[] args) {

        Order o1 = Order.getInstance();
        Order o2 = Order.getInstance();
        System.out.println(o1 == o2); // true

    }

}
class Order {
    // 私有化构造器 ,防止外部造对象
    private Order () {

    }
    // 声明当前类的对象, 没有初始化
    // 此对象必须为static 的
    private static Order instance = null;

    // 声明 public static 的返回当前对象的方法
    public static Order getInstance () {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }


}