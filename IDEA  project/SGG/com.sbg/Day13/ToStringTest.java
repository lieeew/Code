package Day13;

import java.util.Date;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/5 - 09 - 05
 * @Description: Day13
 *
 *
 *
 *    1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
 *
 *   2. Object类中toString()的定义：
 *     public String toString() {
 *         return getClass().getName() + "@" + Integer.toHexString(hashCode());
 *      }
 *
 *   3. 像String、Date、File、包装类等都重写了Object类中的toString()方法。
 *      使得在调用对象的toString()时，返回"实体内容"信息
 *
 *   4. 自定义类也可以重写toString()方法，当调用此方法时，返回对象的"实体内容"
 *
 *
 */
public class ToStringTest {
    public static void main(String[] args) {

        Customer cus = new Customer(12, "lihua");
        System.out.println(cus.toString()); // Day13.Customer@1b6d3586
        System.out.println(cus); // Day13.Customer@1b6d3586

        String str = new String("mm");
        System.out.println(str);

        Date date = new Date(327649823L);
        System.out.println(date);
    }
}
