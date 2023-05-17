package Day18.exer;

import sun.text.resources.cldr.es.FormatData_es_419;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/16 - 10 - 16
 * @Description: Day18.exer
 */

class Account2 implements Runnable{

    private ReentrantLock lock = new ReentrantLock();
    private int totalMoney;

    public Account2(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    // 存钱的方法
    public void addMoney(int mount) {
        try {
            lock.lock();
            if (mount > 0) {
                totalMoney += mount;
                System.out.println(Thread.currentThread().getName() + "** 账户余额为:" + totalMoney);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            addMoney(1000);
        }
    }
}
public class Thread2 {
    public static void main(String[] args) {
        Account2 account2 = new Account2(0);

        Thread a = new Thread(account2);
        Thread b = new Thread(account2);

        a.setName("甲");
        b.setName("乙");

        a.start();
        b.start();
    }
}
