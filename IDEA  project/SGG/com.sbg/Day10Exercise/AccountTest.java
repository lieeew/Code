package Day10Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/19 - 08 - 19
 * @Description: Day10Exercise
 */
public class AccountTest {
    public static void main(String[] args) {
        /*Customer customer = new Customer("li" , "hua");
        Account account = new Account();
        customer.setAccount(account);
        account.withDraw(300.0);
        account.deposit(130.9);*/
        Account acc = new Account(1000,3427823.9,0.013);
        Customer1 cus = new Customer1("Jane", "Smith");
        cus.setAccount(acc);
        cus.getAccount().deposit(100);
        cus.getAccount().withDraw(11111);
        System.out.println("Customer[" + cus.getFirstName() + "," +cus.getLastName()
                        + "] has a accoumt : id is" +cus.getAccount().getId() +
        "annualInterestRate is " + acc.getAnnualInterestRate() + ", balance is" + cus.getAccount().getBalance())  ;

    }
}