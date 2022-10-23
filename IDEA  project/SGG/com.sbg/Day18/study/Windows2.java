package Day18.study;

import javax.print.attribute.standard.MediaSizeName;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/14 - 10 - 14
 * @Description: Day18.study
 */

class ticket1 implements Runnable {
    Object obj = new Object();
    private int TotalTicket = 100;
    @Override
    public void run() {
       show();
    }
    public  void show () {
        synchronized (this) {
            while (true) {
                if (TotalTicket > 0) {
                    System.out.println(Thread.currentThread().getName() + "票数为" + TotalTicket);
                    TotalTicket--;
                }
            }
        }
    }
}
public class Windows2 {
    public static void main(String[] args) {
        ticket1 ticket1 = new ticket1();

        Thread Windows1 = new Thread(ticket1);
        Thread windows2 = new Thread(ticket1);

        Windows1.setName("窗口一");
        windows2.setName("窗口二");

        Windows1.start();
        windows2.start();
    }
}
