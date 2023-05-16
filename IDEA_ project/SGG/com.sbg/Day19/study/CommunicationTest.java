package Day19.study;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/17 - 10 - 17
 * @Description: Day19.study
 */
// 方法前省略对象有两种情况 ① 静态方法 类名.方法  ② 省略 this
/**
 * 线程通信调用的三个常用的方法
 * ① wait() : 一旦使用该方法, 当前线程就会进入阻塞状态 , 并且释放同步监视器
 * ② notify()一旦调用此方法, 就会唤醒被wait() 的一个线程 , 如果有多个线程被wait() 就会先调用优先级高的那个线程
 * ③ notifyAll() : 一旦执行此方法 , 就会唤醒所有被 wait()的线程
 *
 * 注意:
 * 1. 上述三种方法都必须声明在同步方法中或同步方法中
 * 2.上述三种方法的调用者都必须是同步代码块或同步方法的同步监视器一致, 否者会报IllegalMonitorStateException
 * 3. 上述三种方法定义在object类中
 *
 * 面试题: sleep() 和 wait() 异同?
 * `1. 相同点, 两个方法执行都可以让当前线程计入阻塞状态
 *  3. 不同点
 *      ① 两个方法定义的类不同 sleep () 定义在sleep()类中 ; wait() 定义在object类中
 *      ② 调用的要求不同  sleep() 可以再任何场景使用  ; wait()必须在同步代码块或同步方法中
 *      ③ 关于是否释放同步监视器 sleep()不释放  ; wait() 释放同步监视器
 */
class Number implements Runnable {
    private int num = 1;
    Object OBJ = new Object();

    @Override
    public void run() {
        while (true) {
           synchronized (this) {
               this.notify(); // ①两个服务可以其他一个的唤醒线程  ②如果多个线程可以唤醒其他的一个
               if (num <= 100) {
                   System.out.println(Thread.currentThread().getName() + ":" + num);
                   try {
                       wait(); // 会把锁给抛弃
                   } catch (InterruptedException ex) {
                       throw new RuntimeException(ex);
                   }
                   num++;
                   try {
                       Thread.sleep(100); // 睡觉但是不会吧锁给抛弃
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               } else {
                   break;
               }
           }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread a = new Thread(number);
        Thread b = new Thread(number);

        a.setName("线程①");
        b.setName("线程②**");

        a.start();
        b.start();
    }
}
