package Day18.study;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/14 - 10 - 14
 * @Description: Day18.study
 */
class windows extends Thread {

    private static int ticket = 100;
    @Override
    public void run() {
        while (true) {


        }
    }

    private static synchronized void show () { // 同步监视器: 是 windows.class
    // private synchronized void show() { 这里的同步监视器: this的是 t1, t2, t3 所以线程不安全
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ": 序号为:" + ticket);
            ticket--;
        }
    }
}

public class WindowsTest {
    public static void main(String[] args) {

        windows t1 = new windows();
        t1.setName("售票处一");
        t1.start();

        windows t2 = new windows();
        t2.setName("售票处二");
        t2.start();

        windows t3 = new windows();
        t3.setName("售票处三");
        t3.start();
    }
}
