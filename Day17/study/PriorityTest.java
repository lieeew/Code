package Day17.study;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/9 - 10 - 09
 * @Description: Day17.study
 */

/**
 *  getPriority()
 *  setPriority()
 * 优先级高不意味着一定会比低优先级先执行, 这个就像买彩票一样, 概率高不意味着中奖
 *
 */

class test extends Thread {
    @Override
    public void run() {
        for (int a = 0; a < 101; a++) {
            if (a % 2 == 0) {
                System.out.println(getName() + " 线程优先级 :" + getPriority());
            }
        }
    }
}

public class PriorityTest {
    public static void main(String[] args) {
        test test = new test();
        test.setPriority(Thread.MAX_PRIORITY);
        test.start();


        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int a = 0; a < 101; a++) {
            if (a % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "优先级为:" + Thread.currentThread().getPriority());
            }
        }
    }
}
