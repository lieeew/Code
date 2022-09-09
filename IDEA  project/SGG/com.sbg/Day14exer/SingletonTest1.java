package Day14exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/8 - 09 - 08
 * @Description: Day14exer
 */
public class SingletonTest1 {
    public static void main(String[] args) {

        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2); // true
    }

}
// 饿汉式
class Bank {
    private Bank () {

    }

     private static Bank bank = new Bank();

    public static Bank getInstance() {
        return bank;
    }
}
