package Day17.exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/9 - 10 - 09
 * @Description: Day17.exer
 */

/**
 * 三个线程买票, 一共一百张
 */

class windows extends Thread {

    private int ticket = 100;
    @Override
    public void run() {
        while (true) {

            if (ticket > 0) {
                System.out.println(getName() + ": 序号为:" + ticket);
                ticket--;
            } else {
                System.out.println("抱歉没票了");
                break;
            }
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
