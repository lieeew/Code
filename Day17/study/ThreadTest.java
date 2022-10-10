package Day17.study;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/8 - 10 - 08
 * @Description: Day17
 */

/**
 *多线程的创建 方法一
 * ① 创建一个继承与thread类的子类
 * ② 重写thread中的run方法 --> 把要做的事情声明在run方法中
 * ③ 创建thread类子类的对象
 * ④通过此对象调用start()方法
 *
 */
// 例子: 遍历100以内的偶数
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // 通过此对象调用start()方法 二个作用: ① 启动当前线程 ② 调用当前对象的run()
        myThread.start();
        // 如果要创建多个线程需要造多个对象

        MyThread t2 = new MyThread();
        t2.start();


        // 如果直接代用run(), 那么就不会有多线程
        // myThread.run();
    }
}

// 创建一个继承与thread类的子类
class MyThread extends Thread {
    // 如下操作仍在main()方法中执行
    // 重写thread中的run方法
    @Override
    public void run() {
        for (int a = 0; a < 101; a++) {
            if (a % 2 == 0) System.out.println(a);
        }
    }
}