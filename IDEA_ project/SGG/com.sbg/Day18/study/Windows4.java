package Day18.study;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/15 - 10 - 15
 * @Description: Day18.study
 */
public class Windows4 {
    public static void main(String[] args) {

    }
}

class Bank {

    private Bank (){

    }

    private static Bank bank = null;

    public  static  Bank getInstance (){
        // 方式一, 效率稍差
//        synchronized (Bank.class) {
//            if (bank == null) {
//                bank = new Bank();
//            }
//            return bank;
//        }
        // 效率稍高一点
        if (bank == null) { // 这个是一个判断, 如果bank不是null那么就直接return了,不需要在加锁
            synchronized (Bank.class) {
                bank = new Bank();
            }
        }
        return bank;
    }

}