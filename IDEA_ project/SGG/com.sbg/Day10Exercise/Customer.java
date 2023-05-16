package Day10Exercise;

import java.util.Scanner;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/19 - 08 - 19
 * @Description: Day10Exercise
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;
    public Customer() {

    }
    public Customer(String f,String l) {
        firstName = f;
        lastName = l;
    }
    public String getFirstName () {
        return firstName;
    }
    public String getLastName () {
        return lastName;
    }
   public void setAccount (Account account) {
       Scanner sc = new Scanner(System.in);
       System.out.println("请输入您的id:");
       account.setId(sc.nextInt());
       System.out.println("请输入您的账户余额");
       account.setBalance(sc.nextInt());
       System.out.println("请输入您的年利率:");
       account.setAnnualInterestRate(sc.nextDouble());
   }
}
