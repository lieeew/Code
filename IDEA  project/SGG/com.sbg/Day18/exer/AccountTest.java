package Day18.exer;

import javax.management.relation.RoleInfo;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/16 - 10 - 16
 * @Description: Day18.exer
 */

/**
 *银行有一个账户:
 *  有两储户分别向同一个账户存贮3000元, 每次存1000, 存3次
 *
 *  分析:
 *  1. 是否为多线程问题?  是
 *  2. 是否有安全问题 ? 有 , 有共享数据
 *
 *  这个例子中,使用继承的方式 对于同步方法中如何让同步数据: 方法可以创建一个单独的类让各个线程共享
 *
 */
class Account {
    public  int money;

    public Account(int money) {
        this.money = money;
    }

    public synchronized void deposit (int mount) {// 锁是this 指的是唯一创建的acct;
        if (mount > 0)  {
            money += mount;
            System.out.println( Thread.currentThread().getName() + " **存款成功余额为:" + money);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Customer extends Thread {
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;

    }


    @Override
    public  void run() {

        for (int i = 0; i < 3; i++) {
                acct.deposit(1000);
            }
        }
    }
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();

    }
}
