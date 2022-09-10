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
    // 私有化构造器
    private Bank () {

    }
    // 内部创建类的对象
    // 要求此对象必须为静态
     private static Bank bank = new Bank();
    // // 提供公共的方法,返回对象
    public static Bank getInstance() {
        return bank;
    }
}
