package Day18.study;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/16 - 10 - 16
 * @Description: Day18.study
 */

class ticket5 implements Runnable{
    private int TotalTicket = 100;
    // 1. 实例化
    private ReentrantLock Lock = new ReentrantLock(true);// ctrl + p

    @Override
    public void run() {


        while (true) {
            try {
                Lock.lock();
                if (TotalTicket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "售票, 序号为:" + TotalTicket);
                    TotalTicket--;
                }
            } finally {
                // 3. 调用解锁方法
                Lock.unlock();
            }
        }

    }
}
public class Windows5 {
    public static void main(String[] args) {
        ticket5 window = new ticket5();

        Thread windows1 = new Thread(window); // ctrl + D
        Thread windows2 = new Thread(window);
        Thread windows3 = new Thread(window);

        windows1.setName("窗口一");
        windows2.setName("窗口二");
        windows3.setName("窗口三");

        windows1.start();
        windows2.start();
        windows3.start();
    }
}
