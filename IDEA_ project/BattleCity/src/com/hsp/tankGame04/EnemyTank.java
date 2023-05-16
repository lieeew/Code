package com.hsp.tankGame04;

import java.util.Stack;
import java.util.Vector;


/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/20 - 12 - 20
 * @Description: com.hsp.tankGame02
 */
public class EnemyTank extends Tank implements Runnable{
    private Vector<Shot> shots = new Stack<>(); // 子弹的线程
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    @Override
    public void run() {
        while (true) {
            switch (getDirection()) {
                case "W":
                    for (int i = 0; i < 20; i++) {
                        if (getY() > 0) { // 向上移动y必须大于0
                            moveUp();
                        }
                    }
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "S":
                    for (int i = 0; i < 20; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                    }
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "A":
                    for (int i = 0; i < 20; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                    }
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "D":
                    for (int i = 0; i < 20; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                    }
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int choice = (int) (Math.random() * 5 + 1); // [1,4] 随机数
            switch (choice) {
                case 1:
                    setDirection("W");
                    break;
                case 2:
                    setDirection("S");
                    break;
                case 3:
                    setDirection("A");
                    break;
                case 4:
                    setDirection("D");
                    break;
            }
            //听老韩说，写并发程序，一定要考虑清楚，该线程什么时候结束
            if (!isLive()) {
                break;
            }
        }
    }
}
