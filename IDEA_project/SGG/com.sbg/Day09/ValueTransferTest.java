package Day09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/13 - 08 - 13
 * @Description: Day09
 */
public class ValueTransferTest {
    public static void main(String[] args) {
        int m = 10;
        int n = m;
        System.out.println("m =" + m);
        System.out.println("n =" + n);
        Order a1 = new Order();
        a1.OrdeId = 1001;
        Order b = a1;
        System.out.println("a =" + a1.OrdeId + ",b = " + b.OrdeId );
        b.OrdeId = 2002;
        System.out.println("a =" + a1.OrdeId + ",b = " + b.OrdeId);
    }
}
class Order {
    int OrdeId;
}
