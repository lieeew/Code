package Day10Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/21 - 08 - 21
 * @Description: Day10Test
 */
public class BankTest3 {
    public static void main(String[] args) {
        Bank b = new Bank();
        for (int a = 0; a < 10; a ++) {
            b.addCustomer("liu", "hua");
            System.out.println(b.getCustomer(a).getFirstName());
        }
    }
}
