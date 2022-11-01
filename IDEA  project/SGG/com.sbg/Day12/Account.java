package Day12;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/1 - 09 - 01
 * @Description: Day12
 */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    public Account (int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public void withdraw (double amount) {// 取钱
        if (amount > 0 && balance >= amount) {
            balance  -= amount;
            System.out.println("取款成功,余额为" + balance);
        }else {
            System.out.println("余额不足!!");
        }
    }
    public void deposit (double amount) {//存钱
        if (amount > 0) {
            balance += amount;
            System.out.println("存款成功,余额为" + balance);
        }
    }
}
