package Day0;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/11 - 09 - 11
 * @Description: Day0
 */

/**
 *
 * 饿汉式
 */
public class SingTest {
    public static void main(String[] args) {
        Bank b1 = Bank.getBank();
        Bank b2 = Bank.getBank();
        System.out.println(b1 == b2);
    }
}
class Bank {

    private Bank () {

    }

    private static Bank bank = new Bank();

    public  static Bank getBank () {
        return bank;
    }
}
