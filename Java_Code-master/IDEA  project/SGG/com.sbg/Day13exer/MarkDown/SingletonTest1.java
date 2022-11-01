package Day13exer.MarkDown;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/10 - 09 - 10
 * @Description: MarkDown
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Account a1 = Account.getInstance();
        Account a2 = Account.getInstance();
        System.out.println(a1 == a2);
    }
}

class Account {

    private Account () {
    }

    private static Account sc = new Account();

    public static Account getInstance() {
        return sc;
    }
}