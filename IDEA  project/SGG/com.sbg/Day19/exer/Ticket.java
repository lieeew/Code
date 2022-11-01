package Day19.exer;

import javax.swing.text.MutableAttributeSet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/20 - 10 - 20
 * @Description: Day19.exer
 */
class Total extends Thread {

    private static int totalTicket = 100;

    private static ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            consumeTicket();
        }
    }

    private static void consumeTicket() {
        try {
            reentrantLock.lock();
            if (totalTicket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 票号为:" + totalTicket);
                totalTicket--;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
public class Ticket {
    public static void main(String[] args) {

        Total total1 = new Total();
        Total total2 = new Total();
        Total total3 = new Total();

        total1.setName("售票口一");
        total2.setName("售票口二");
        total3.setName("售票口三");

        total1.start();
        total2.start();
        total3.start();

    }
}
