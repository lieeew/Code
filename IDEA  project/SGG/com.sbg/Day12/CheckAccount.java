package Day12;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/1 - 09 - 01
 * @Description: Day12
 */
public class CheckAccount extends Account{
    private double overdraft;


    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount < getBalance()) {
            super.withdraw(amount);
            System.out.println("您的可透支额度：" + overdraft);
        }else {
            if (amount > (getBalance() + overdraft)) {// 注意是banlance + overdraft
                System.out.println("超过可透支额的限额!");
            }else {
                overdraft -= (amount - getBalance());
                setBalance(0);
                System.out.println("账户余额为:" +getBalance());
                System.out.println("信用卡可透额" + overdraft);
            }
        }
    }
}
