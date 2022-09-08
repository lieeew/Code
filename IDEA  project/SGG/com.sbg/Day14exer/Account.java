package Day14exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/8 - 09 - 08
 * @Description: Day14exer
 */

/**
 * 编写一个类实现银行账户的概念，包含的属性有“帐号”、“密
 * 码”、“存款余额”、“利率”、“最小余额”，定义封装这些
 * 属性的方法。账号要自动生成。
 * 编写主类，使用银行账户类，输入、输出3个储户的上述信息。
 */
public class Account {

    private int id;
    private String password;
    private double balance; // 余额


    private static double TnterestRate;
    private static double MinMoney ;
    private static int init = 1001; // 用于自动赋值

    public Account(String password, double balance) {
        this.password = password;
        this.balance = balance;
        id = init ++;
    }

    public Account() {
        id = init ++;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password ) {
        this.password = password;
    }

    public static double getTnterestRate() {
        return TnterestRate;
    }

    public static void setTnterestRate(double tnterestRate) {
        TnterestRate = tnterestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public int getId() {
        return id;
    }

    public static double getMinMoney() {
        return MinMoney;
    }

    public static void setMinMoney(double minMoney) {
        MinMoney = minMoney;
    }

    @Override
    public String toString() { // 美化代码 Alt + Shift + J
        return "Account{id=" + id + ", password='" + password + '\'' + ", balance=" + balance + '}'; }
}
