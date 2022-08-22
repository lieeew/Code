package Day10Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/20 - 08 - 20
 * @Description: Day10Test
 */
public class BankTest {
    public static void main(String[] args) {
        Bank b = new Bank();
        Account acc = new Account(2000);
        b.addCustomer("li", "hua");
        // b.getCustomer(0).setAccount(new Account(1000));
        // System.out.println("您的名字为:" + b.getCustomer(0).getFirstName() + b.getCustomer(0).getLastName());
        b.getCustomer(0).setAccount(acc);
        double a = acc.deposit(100);
        System.out.println(a);
        acc.withDraw(20);
        b.addCustomer("万里", "杨");
        System.out.println("客户的数量" + b.getNumberofCustomers());
    }
}
