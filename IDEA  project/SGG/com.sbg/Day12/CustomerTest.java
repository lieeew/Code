package Day12;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/1 - 09 - 01
 * @Description: Day12
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer cus = new Customer("Smith", "Jane");
        Account ac = new Account(1122, 20000, 0.0024);
        ac.withdraw(30000);
        ac.withdraw(2500);
        ac.deposit(3000);
        System.out.println("月利率为" + (ac.getAnnualInterestRate() * 100) + "%");



    }
}
