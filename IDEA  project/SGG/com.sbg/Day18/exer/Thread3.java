package Day18.exer;

import Day12.Account;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/16 - 10 - 16
 * @Description: Day18.exer
 */

class Account3 {
    private int totalMoney;
    private ReentrantLock Lock = new ReentrantLock();

    public Account3(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void addMony (int amount) {
        try {
            Lock.lock();
            if (amount > 0) {
                totalMoney += amount;
                System.out.println(Thread.currentThread().getName() + "余额为" + totalMoney);
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Lock.unlock();
        }
    }
}

class Customer3 extends Thread {
    private Account3 account3;
    public Customer3 (Account3 account3) {
        this.account3 = account3;
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account3.addMony(1000);
        }
    }
}
public class Thread3 {
    public static void main(String[] args) {
        Account3 acc = new Account3(0);

        Customer3 a = new Customer3(acc);
        Customer3 b = new Customer3(acc);

        a.setName("甲");
        b.setName("乙");

        a.start();
        b.start();
    }
}