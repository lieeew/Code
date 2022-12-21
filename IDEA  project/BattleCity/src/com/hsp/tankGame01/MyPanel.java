package com.hsp.tankGame01;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.tankGame
 */
public class MyPanel extends JPanel {
    // 定义一下我的坦克
    private Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // 填充矩形
        drawTank(hero.getX(), hero.getY(), g, 0, 0);

    }


    /**
     * 画坦克
     * @param x 坦克的横坐标
     * @param y 坦克的纵坐标
     * @param g 画笔
     * @param direction 坦克的方向 0是向上
     * @param type 坦克的类型 0是自己 , 1是敌人
     */
    public void drawTank (int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.YELLOW);
                break;
        }

        switch (direction) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false); //左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);// 中间的
                g.fillOval(x + 10, y + 20, 20, 20); // 坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            default:
                System.out.println("其他的情况");
        }
    }
}
