package com.qxy.MyIdea.tankGame02;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/21 - 12 - 21
 * @Description: com.qiuxinyu.MyIdea.tankGame02
 * 子弹类
 */
public class Bullets extends JFrame implements Runnable{
    private int speed = 1; // 子弹的速度
    private int bulletNums = 0;
    private Hero hero; // 坦克的对象
    private int X;
    private int Y;

    public Bullets(int speed, int bulletNums, int x, int y) {
        this.speed = speed;
        this.bulletNums = bulletNums;
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @Override
    public void run() {

    }

    public void SetInformation(@NotNull Hero hero) {
        int positionX = hero.getPositionX();
        int positionY = hero.getPositionY();
        KeyEvent towards = hero.getTowards();

        if (towards.getKeyCode() == KeyEvent.VK_W) {
            X = positionX + 20;
            Y = positionY;
        } else if (towards.getKeyCode() == KeyEvent.VK_S) {
            X = positionX + 20;
            Y = positionY + 60;
        } else if (towards.getKeyCode() == KeyEvent.VK_A) {
            X = positionX;
            Y = positionY + 20;
        } else if (towards.getKeyCode() == KeyEvent.VK_D) {
            X = positionX + 60;
            Y = positionY + 20;
        }
    }
}
