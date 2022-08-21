package Day10Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/20 - 08 - 20
 * @Description: Day10Test
 */
public class BankTest2 {
    public static void main(String[] args) {
        Bank b = new Bank();
        b.addCustomer("Jane", "Smith");
        b.getCustomer(0).setAccount(new Account(2000));
        b.getCustomer(0).getAccount().withDraw(100);
    }
}
