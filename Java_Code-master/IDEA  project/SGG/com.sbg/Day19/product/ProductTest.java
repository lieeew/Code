package Day19.product;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/17 - 10 - 17
 * @Description: Day19.product
 */

import com.sun.corba.se.impl.oa.toa.TOA;

import static java.lang.Thread.sleep;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 *
 * 分析:
 * 1. 是否有多线程问题 ? 有, 生产线 和 消费线
 * 2. 是否有共享数据源? 有 产品(或者店员)
 * 3. 如何解决线程安全问题 ? 同步机制 3总方法
 * 4. 是否涉及线程的通信 ? 是
 */

class Clerk { // 店员
    private  int TotalGoods = 0;

    public synchronized void ConsumeProduct() { // 消费产品  同步监视器是唯一创建的对象： clerk
        if (TotalGoods > 0) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": 消费的序号为 " + TotalGoods);
            TotalGoods--;

            notify(); // 消费一个快就可以唤醒消费者
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized void ProduceProduct() { // 生产产品
        if (TotalGoods < 19) {
//            try {
//                sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            TotalGoods++;
            System.out.println(Thread.currentThread().getName() + " 生产者序号 :" + TotalGoods);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

class Customer extends Thread{ // 消费者
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始消费...");

        while (true) {
            clerk.ConsumeProduct();
        }
    }
}

class Producer extends Thread{ // 生产者
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始生产..." );

        while (true) {
            clerk.ProduceProduct();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        Customer p2 = new Customer(clerk);

        p1.setName("生产者");
        p2.setName("消费者");

        p1.start();
        p2.start();

    }
}
