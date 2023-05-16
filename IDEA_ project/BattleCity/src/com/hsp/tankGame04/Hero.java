package com.hsp.tankGame04;

import java.util.Vector;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.tankGame
 * 自己的坦克
 */
public class Hero extends Tank {
    private Shot shot = null; // 子弹线程
    private Vector<Shot> shots = new Vector<>(); // 子弹的集合
    public Hero(int x, int y) {
        super(x, y);
    }

    public Vector<Shot> getShots() {
        return shots;
    }

    public Shot getShot() {
        return shot;
    }

    public void shotEnemyTank() {
        // 最多5颗子弹, 控制自己
        if (shots.size() == 5) {
            return;
        }
        switch (getDirection()) {
            case "W":
                new Thread(shot = new Shot(getX() + 20, getY(), "W")).start();
                shots.add(shot); // 把这个添加到集合之中
                break;
            case "S":
                new Thread(shot = new Shot(getX() + 20, getY() + 60, "S")).start();
                shots.add(shot);
                break;
            case "A":
                new Thread(shot = new Shot(getX(), getY() + 20, "A")).start();
                shots.add(shot);
                break;
            case "D":
                new Thread(shot = new Shot(getX() + 60, getY() + 20, "D")).start();
                shots.add(shot);
                break;
        }
    }
}
