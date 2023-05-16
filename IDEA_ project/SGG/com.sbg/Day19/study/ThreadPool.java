package Day19.study;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/19 - 10 - 19
 * @Description: Day19.study
 */

/**
 * 优点:
 * 1. 提高响应速度(减少创建线程的时间)
 * 2. 降低资源的消耗 (重复利用线程池的线程, 不需要每次都创建)
 * 3. 便于线程管理

 *  创建多线程的方式 : 4 种
 */

import java.util.concurrent.*;
class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

class NewTest2 implements Callable {
    int sum = 0;
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 101; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}

class NewTest3 implements Callable {
    int sum = 0;
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor serve1 = (ThreadPoolExecutor) service;
        serve1.setMaximumPoolSize(10);
        // serve1.setKeepAliveTime();

//        service.execute(new NumberThread()); // 适用于Runnable接口
//        // 关闭线程池
//        service.shutdown();

        Future submit = service.submit(new NewTest2());// 适用于Callable接口

        try {
            Object num = submit.get();
            Integer Number = (Integer)num;
            System.out.println("总数为:" + Number);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        Future submit1 = service.submit(new NewTest3());



        service.shutdown();
    }
}
