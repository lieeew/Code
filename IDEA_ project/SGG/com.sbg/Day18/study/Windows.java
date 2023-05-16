package Day18.study;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/13 - 10 - 13
 * @Description: Day18.study
 */

import Day13.Man;

/**
 * 问题: 票数可以会出现负数
 * 原因: 在一个线程处理共享数据未完成时, 另外一个线程又参与进来
 * 解决: 当一个线程a在操作ticket, 其他线程不能进入直到线程a操作完ticket后其他线程才能进入
 * 在java中, 我们通过同步机制, 来解决线程问题
 *
 * 方式一: 同步代码块
 *   synchronized (同步监视器) {
 *       需要被同步的代码
 *       // 1.需要共享数据的代码, 就是需要被同步的代码
 *       // 2.共享数据, 多个进程操作同一数据
 *       // 3.同步监视器 俗称"锁" 任何一个对象都可以来充当锁 ,公用一个锁
 *   }
 *
 *
 *   同步代码快
 *    局限性: 内部只能单线程,
 */

class ticket implements Runnable {
    private int ticket = 100;
//    Object obj = new Object();
    Dog dog = new Dog();
    @Override
    public void run() {

          while (true) {
              synchronized (dog) {
                  if (ticket > 0) {
//                      try {
//                          Thread.sleep(100);
//                      } catch (InterruptedException e) {
//                          throw new RuntimeException(e);
//                      }
                      System.out.println(Thread.currentThread().getName() + "票号为：" + ticket);
                     ticket--;
                  } else {
                      System.out.println("抱歉没有票了");
                      break;
              }
          }
      }
    }
}

class Dog {

}
public class Windows {
    public static void main(String[] args) {
        ticket ticket = new ticket();  // 只创建了一个锁


        Thread ticketWindows1 = new Thread(ticket);
        Thread ticketWindows2 = new Thread(ticket);
        ticketWindows1.setName("售票口一");
        ticketWindows2.setName("售票口二");

        ticketWindows1.start();
        ticketWindows2.start();


    }
}
