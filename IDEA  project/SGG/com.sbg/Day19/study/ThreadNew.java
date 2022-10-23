package Day19.study;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/18 - 10 - 18
 * @Description: Day19.study
 */

/**
 * ① 创建一个实现callable的实现类
 * ② 实现call() 方法, 将线程需要执行的出操作说明在call()
 * ③ 创建callable实现类的对象
 * ④ 将此Callable接口实现类的对象传递到FutureTask的构造器中 , 创建FutureTask的对象
 * ⑤ 将FutureTask的对象传递到Thread类的构造器中 , 创建Threadd对象 , 并调用start()
 * ⑥ 获取Callable 中call方法的方法回值
 *
 * 创建一个实现callable比实现类和Runnable接口更强大?
 * ① call有返回值
 * ② call() 可以抛出异常, 被外面的操作捕获, 获取异常的信息
 * ③ Callable 支持泛型
 */

// ① 创建一个实现callable的实现类
class NumThread implements Callable {
    // ② 实现call() 方法, 将线程需要执行的出操作说明在call()
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum; // sum不是Object的子类, 这里涉及自动装箱,装箱为Integer
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        // ③ 创建callable实现类的对象
        NumThread numThread = new NumThread();
        // ④ 将此Callable接口实现类的对象传递到FutureTask的构造器中 , 创建FutureTask的对象
        FutureTask futureTask = new FutureTask(numThread);
        // ⑤ 将FutureTask的对象传递到Thread类的构造器中 , 创建Threadd对象 , 并调用start()
        new Thread(futureTask).start();

        try {
            // ⑥ 获取Callable 中call方法的方法回值
            // get返回的为FutureTask构造器参数 Callable实现类重写的call() 的返回值
            Object sum = futureTask.get();
            System.out.println( "中和为" + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
