package Day10Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/19 - 08 - 19
 * @Description: Day10Exercise
 */
public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer("li" , "hua");
        Account account = new Account();
        customer.setAccount(account);
        account.withDraw(300.0);
        account.deposit(130.9);

    }
}

