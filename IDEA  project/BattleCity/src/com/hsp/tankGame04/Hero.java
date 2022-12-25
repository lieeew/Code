package com.hsp.tankGame04;

import java.awt.event.KeyEvent;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.tankGame
 * 自己的坦克
 */
public class Hero extends Tank {
    private Shot shot = null; // 子弹线程
    private KeyEvent towards;
    public Hero(int x, int y) {
        super(x, y);
    }

    public void setTowards(KeyEvent towards) {
        this.towards = towards;
    }

    public Shot getShot() {
        return shot;
    }

    public void shotEnemyTank() {
        switch (getDirection()) {
            case "W":
                new Thread(shot = new Shot(getX() + 20, getY(), "W")).start();
                break;
            case "S":
                new Thread(shot = new Shot(getX() + 20, getY() + 60, "S")).start();
                break;
            case "A":
                new Thread(shot = new Shot(getX(), getY() + 20, "A")).start();
                break;
            case "D":
                new Thread(shot = new Shot(getX() + 60, getY() + 20, "D")).start();
                break;
        }
    }
}
