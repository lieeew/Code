package Day10Exercise2;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/21 - 08 - 21
 * @Description: Day10Exercise2
 */
public class Account {
    private double balance;
    public Account (double init_balance) {
        balance = init_balance;

    }
    public double getBalance () {
        return balance;
    }
    // 存款
    public void deposit (double amt) {
        balance += amt;
        System.out.println("存款成功,余额为:" + balance);
    }
    public void withDraw (double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println(amt + "取款成功,余额为" + balance );
        }else {
            System.out.println("余额不足");
        }
    }
}
