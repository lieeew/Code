package com.hsp.tankGame04;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Stack;
import java.util.Vector;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/20 - 12 - 20
 * @Description: com.hsp.tankGame02
 */
public class EnemyTank extends Tank {
    private Vector<Shot> shots = new Stack<>(); // 子弹的线程
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public Vector<Shot> getShots() {
        return shots;
    }

//    private String position = "W"; // 方向以后再考虑

    /**
     * 随机移动
     * @param tank  坦克
     */
    public static void MoveFreely(@NotNull Tank tank) {
        int num = (int)(Math.random() * 10 + 1);
        switch (tank.getDirection()) {
            case "W":
                tank.setY(tank.getY() - num);
                break;
            case "S":
                tank.setY(tank.getY() + num);
                break;
            case "A":
                tank.setX(tank.getY() - num);
                break;
            case "D":
                tank.setX(tank.getY() + num);
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
                tank.setDirection("W");
                break;
            case 2:
                tank.setDirection("S");
                break;
            case 3:
                tank.setDirection("A");
                break;
            case 4:
                tank.setDirection("D");
                break;
        }

    }
}
