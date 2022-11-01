package Day18.study;

import javax.swing.plaf.synth.SynthColorChooserUI;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/14 - 10 - 14
 * @Description: Day18.study
 */

class Ticket3 implements Runnable{
    private int total = 100;


    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() {
        if (total > 0) {
            System.out.println(Thread.currentThread().getName() + "票的序号为" + total);
            total--;
        }
    }
}
public class Windows3 {
    public static void main(String[] args) {
        Ticket3 Windows = new Ticket3();

        Thread windows1 = new Thread(Windows);
        Thread windows2 = new Thread(Windows);
        Thread windows3 = new Thread(Windows);

        windows1.setName("售票口1");
        windows2.setName("售票口2");
        windows3.setName("售票口3");

        windows1.start();
        windows2.start();
        windows3.start();
    }
}
