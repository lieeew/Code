package Day13exer.MarkDown;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/7 - 09 - 07
 * @Description: MarkDown
 */
public class aaa {
    public static void main(String[] args) {
        order order = new order();
        System.out.println(order.isFemale); // null
        System.out.println(order.isMale); // false
    }
}
class order {
    boolean isMale;
    Boolean isFemale;
}
