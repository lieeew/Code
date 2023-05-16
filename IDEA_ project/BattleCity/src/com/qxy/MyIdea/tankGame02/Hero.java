package com.qxy.MyIdea.tankGame02;

import java.awt.event.KeyEvent;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.tankGame
 * 自己的坦克
 */
public class Hero extends Tank {
    private Bullets bullets; // 子弹
    private KeyEvent e; // 从键盘上获取的按键
    public Hero(int x, int y) {
        super(x, y);
    }

    public Bullets getBullets() {
        return bullets;
    }

    public void setBullets(Bullets bullets) {
        this.bullets = bullets;
    }
    // 获取他现在的信息
    public int getPositionX() {
        return getX();
    }
    public int getPositionY() {
        return getY();
    }
    public KeyEvent getTowards() {
        return e;
    }
    public void setKetEvent(KeyEvent e) {
        this.e = e;
    }
}
