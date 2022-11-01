package Day10Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/20 - 08 - 20
 * @Description: Day10Test
 */
public class Account {
    private double balance;
    public Account () {
    }
    public Account (double init_balance) {
        this.balance = init_balance;
    }
    public double getBalance () {

        return balance;
    }
    // 存钱
    public double deposit (double amt) {
        balance += amt;
        return amt + balance;
    }
    // 取钱
    public void withDraw (double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println(amt +"取款成功,当前余额为" + balance );
        }else {
            System.out.println("取款失败,请检查余额");
        }
    }
}
