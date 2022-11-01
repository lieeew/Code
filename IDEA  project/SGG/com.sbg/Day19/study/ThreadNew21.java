package Day19.study;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/18 - 10 - 18
 * @Description: Day19.study
 */

class NewThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class ThreadNew21 {
    public static void main(String[] args) {
        NewThread newThread = new NewThread();

        FutureTask futureTask = new FutureTask(newThread);

        new Thread(futureTask).start();

        try {
            Object sum = futureTask.get();
            System.out.println("中和为:" + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
