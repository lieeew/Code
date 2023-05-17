package com.qxy.MyIdea.tankGame02;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.tankGame
 */
public class MyPanel extends JPanel implements KeyListener {
    // 定义一下我的坦克
    private Hero hero = null;
    private Bullets bullets = null;
    // 定义敌方坦克
    private int enemyTankSize = 3;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    public MyPanel() {
        // 初始化自己的坦克
        hero = new Hero(100 , 100);
        // 初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank(100 * (i +1), 0));
        }
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // 填充矩形
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);

        // 画出敌方的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            enemyTank.setDirection("S");
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
        }
        // 画出子弹


    }

    /**
     * 画坦克
     * @param x 坦克的横坐标
     * @param y 坦克的纵坐标
     * @param g 画笔
     * @param direction 坦克的方向 W是向上 A是向左 D是向右 S是向下
     * @param type 坦克的类型 0是自己 , 1是敌人
     */
    public void drawTank (int x, int y, Graphics g, String direction, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.YELLOW);
                break;
        }

        switch (direction) {
            case "W":
                g.fill3DRect(x, y, 10, 60, false); //左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);// 中间的
                g.fillOval(x + 10, y + 20, 20, 20); // 坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y); // 炮筒
                break;
            case "S":
                g.fill3DRect(x, y, 10, 60, false); //左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);// 中间的
                g.fillOval(x + 10, y + 20, 20, 20); // 坦克的圆形盖子
                g.drawLine(x + 20, y + 60, x + 20, y + 30); // 炮筒
                break;
            case "D":
                g.fill3DRect(x, y, 60, 10, false);// 上面的轮子
                g.fill3DRect(x, y + 30, 60, 10, false); // 下面的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);// 中间的轮子
                g.drawOval(x + 20, y + 10, 20, 20); // 圆形的盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20); // 炮筒
                break;
            case "A":
                g.fill3DRect(x, y, 60, 10, false);// 上面的轮子
                g.fill3DRect(x, y + 30, 60, 10, false); // 下面的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);// 中间的轮子
                g.drawOval(x + 20, y + 10, 20, 20); // 圆形的盖子
                g.drawLine(x , y + 20, x + 30, y + 20); // 炮筒
                break;
        }
    }

    @Override
    public void keyTyped(@NotNull KeyEvent e) {

    }

    @Override
    public void keyPressed(@NotNull KeyEvent e) {
        hero.setKetEvent(e);
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection("W");
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection("S");
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection("A");
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection("D");
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_J){
            CreatBullet(bullets, e, hero);
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void CreatBullet(Bullets bullets, @NotNull KeyEvent e, Hero hero) {
//        if (e.getKeyCode() == KeyEvent.VK_W) {
//            bullets.setX(hero.getX() + 20);
//            bullets.setY(hero.getY());
//        } else if (e.getKeyCode() == KeyEvent.VK_S) {
//            bullets.setX(hero.getX() + 20);
//            bullets.setY(hero.getY() + 60);
//        } else if (e.getKeyCode() == KeyEvent.VK_A) {
//            bullets.setX(hero.getX());
//            bullets.setY(hero.getY() + 20);
//        } else if (e.getKeyCode() == KeyEvent.VK_D) {
//            bullets.setX(hero.getX() + 60);
//            bullets.setY(hero.getX() + 20);
    }
}
