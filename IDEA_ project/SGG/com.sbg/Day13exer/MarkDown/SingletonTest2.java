package Day13exer.MarkDown;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/10 - 09 - 10
 * @Description: MarkDown
 */
public class SingletonTest2 {
    public static void main(String[] args) {

        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);

    }
}

class Bank {

    // 私有化构造器 ,防止外部造对象
    private Bank () {

    }

    // 声明当前类的对象, 没有初始化
    // 吃对象必须为static 的
    private static Bank bank = null;

    // 声明 public static 的返回当前对象的方法
    public static Bank getInstance () {
        if (bank == null) {
            bank = new Bank();
        }
        return bank;
    }

}
