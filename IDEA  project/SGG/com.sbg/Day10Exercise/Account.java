package Day10Exercise;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/19 - 08 - 19
 * @Description: Day10Exercise
 */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    public Account () {

    }
    public Account (int id, double balance, double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
        this.id = id;
        this.balance = balance;
    }
    public int getId () {
        return id;
    }
    public double getAnnualInterestRate () {
        return annualInterestRate;
    }
    public void setId (int id) {
        this.id = id;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance () {
        return balance;
    }
    public void setAnnualInterestRate (double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public void withDraw (double count) {
        if (count > balance) {
            System.out.println("余额不足");
        }else {
            System.out.println(count + "取款成功");
            System.out.println("余额为" + (balance - count));
        }
    }
    public void deposit (double amount) {
        System.out.println("存款成功,当前余额为" + (amount + balance));
    }
}
