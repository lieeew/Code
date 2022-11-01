package Day17.study;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/8 - 10 - 08
 * @Description: Day17.study
 */

import com.sun.xml.internal.bind.v2.runtime.output.FastInfosetStreamWriterOutput;

/**
 * 测试thread 方法
 * ①start() : 启动当前线程 ; 调用当前线程的run()
 * ②run() 通常需要需要重写thread类的此方法, 将创建的线程所要执行的操作在此方法中
 * ③currentThread() 静态方法 返回当前运行的线程
 * ④ getName 获取当前线程的名字
 * ⑤ setName 设置名字
 * ⑥yield() 释放当前CPU的执行权
 * ⑦ join() 在线程a中调用线程b的join方法, 那么线程a停下来等线程b执行结束
 * ⑧ stop() 强行结束生命周期  不推荐使用
 * ⑨ sleep() 睡眠时间, 以毫秒为单位
 * ⑩isAlive() 判断该线程是否还存活
 */

class HelloThread extends Thread {
    public HelloThread (String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

//            if (i % 20 == 0) {
//                this.yield();
//            }

        }
    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread t1 = new HelloThread("线程一");
        t1.start();



        // 给主线程,命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i == 20) {
                System.out.println(t1.isAlive());
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
