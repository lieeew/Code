package Day0;


/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/11 - 09 - 11
 * @Description: Day0
 */

/**
 * 懒汉式
 */
public class SingTest2 {
    public static void main(String[] args) {
        Order o1 = Order.getInstance();
        Order o2 = Order.getInstance();
        System.out.println(o1 == o2);

    }
}


class Order {

    private Order () {

    }

    private static Order order = null;

    public static Order getInstance() {
        if (order == null) {
            order = new Order();
         }
        return order;
    }

}