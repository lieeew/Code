package Day10Exercise2;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/21 - 08 - 21
 * @Description: Day10Exercise2
 */
public class BankTest {
    public static void main(String[] args) {
        Bank b = new Bank();
        b.addCustomer("万里", "杨");
        b.getCustomer(0).setAccount(new Account(1000));
        b.getCustomer(0).getAccount().withDraw(100);
        b.getCustomer(0).getAccount().deposit(10000);
        b.addCustomer("hua", "li");
        System.out.println("客户的数量为:" + b.getNumberOfCustomers());
    }
}
