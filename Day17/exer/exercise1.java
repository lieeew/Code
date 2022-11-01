package Day17.exer;

import Day12.SuperTest;

import javax.management.relation.RelationNotFoundException;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/10/8 - 10 - 08
 * @Description: Day17.exer
 */

// 两个线程一个遍历偶数一个遍历奇数
public class exercise1 {
    public static void main(String[] args) {
        text1 text1 = new text1();
        text2 text2 = new text2();
        text1.start();
        text2.start();

        // 创建Thread的匿名子类的对象
        new Thread() {
                @Override
                public void run() {
                    for (int a = 0; a < 101; a++) {
                        if (a % 2 != 0) {
                            System.out.println(Thread.currentThread().getName() +  ":" + a);
                        }
                    }
                }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("我错了");
            }
        }.start();
    }


}

class text1 extends Thread {
    @Override
    public void run() {
        for (int a = 0; a < 101; a++) {
            if (a % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + a );
            }
        }
    }
}

class text2 extends Thread {
    @Override
    public void run() {
        for (int a = 0; a < 101; a++) {
            if (a % 2 != 0) {
                System.out.println(Thread.currentThread().getName() +  ":" + a);
            }
        }
    }
}