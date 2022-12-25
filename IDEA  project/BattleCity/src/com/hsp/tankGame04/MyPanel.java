package com.hsp.tankGame04;

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
public class MyPanel extends JPanel implements KeyListener , Runnable{
    // 定义一下我的坦克
    private Hero hero = null;
    // 定义敌方坦克
    private int enemyTankSize = 3;
    private Vector<EnemyTank> enemyTanks = new Vector<>(); // 敌方坦克的集合
    // 定义爆照相关的属性
    private Vector<Bomb> bombs = new Vector<>();
    private Image img1; // 第一张图片资源
    private Image img2;
    private Image img3;
    public MyPanel() {
        // 初始化自己的坦克
        hero = new Hero(100 , 100);
        // 初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank =  new EnemyTank(100 * (i + 1), 0);
            enemyTanks.add(enemyTank);

            // 初始化子弹
            Shot shot = new Shot(enemyTank.getX() + 10, enemyTank.getY() + 60, "S");
            enemyTank.getShots().add(shot); // 把子弹对象添加成员属性之中便于管理
            new Thread(shot).start(); // 启动这个线程
        }
        // 初始化图片
        img1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        img2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        img3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // 填充矩形
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
        // 画出敌方的坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            // 判断敌人坦克是否存活
            if (enemyTank.isLive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
            } else {
                enemyTanks.remove(enemyTank);
            }
            /*
            每一个敌方坦克都有对应的Vector<>集合, 现在测试的是只有一个子弹也可以有多个
            */
            // 画出敌方的子弹
            for (int j = 0; j < enemyTank.getShots().size(); j++) {
                Shot shot = enemyTank.getShots().get(j);
                if (shot.isLive()) {
                    g.draw3DRect(shot.getX(), shot.getY(), 5, 5, false);
                } else {
                    enemyTank.getShots().remove(shot);
                }
            }
        }
        // 敌方坦克子弹
        /*
        这个思路是从敌方坦克中取出来x和y, 但是你没有意识到一开始根本就没有子弹的数据,
        所以还是需要在画出坦克时new一个子弹加入到子弹对应的vector数组中, 下面的方法就犯了这个这个问题

        Iterator<EnemyTank> iterator = enemyTanks.iterator(); // 获取坦克的数据
        while (iterator.hasNext()) {
            EnemyTank enemyTank = iterator.next();
            Iterator<Shot> iterator_shot = enemyTank.getShots().iterator(); // 获取子弹的数据
            if (iterator_shot.next().isLive()) { // 子弹存在的条件
                g.draw3DRect(enemyTank.getX() + 10, enemyTank.getY() + 60, 1, 1, false);
                new Thread(iterator_shot.next()).start();
            }
       }
       */

        // 自己的子弹
        if (hero.getShot() != null && hero.getShot().isLive()) {
            System.out.println("*********");
            Shot shot = hero.getShot();
            g.draw3DRect(shot.getX(), shot.getY(), 1, 1, false);
        }

        // 画出爆照效果
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.getLeftTime() > 6) {
                g.drawImage(img1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLeftTime() > 3) {
                g.drawImage(img2, bomb.getX(), bomb.getY(), 60, 60, this);
            } else {
                g.drawImage(img3, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            bomb.leftDown(); // 实生命值减少
            // 如果生命值为0那么就从集合中删除
            if (bomb.getLeftTime() == 0) {
                bombs.remove(bomb);
            }
        }
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
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
        }

        this.repaint();
    }
    // 子弹打到坦克
    public void stocked(Shot shot, @NotNull EnemyTank enemyTank_) {
        if (enemyTank_.getDirection().equals("W") || enemyTank_.getDirection().equals("S")) {
            if (shot.getX() >= enemyTank_.getX() && shot.getX() <= enemyTank_.getX() +
                    40 && shot.getY() >= enemyTank_.getY() && shot.getY() <= enemyTank_.getY() + 60) {
                shot.setLive(false);
                enemyTank_.setLive(false);
                // 创建一个bomb对象, 加入到集合之中
                Bomb bomb = new Bomb(enemyTank_.getX(), enemyTank_.getY());
                bombs.add(bomb); // 添加到集合之中
            }
        } else {
            if (shot.getX() >= enemyTank_.getX() && shot.getX() <= enemyTank_.getX() +
                    60 && shot.getY() >= enemyTank_.getY() && shot.getY() <= enemyTank_.getY() + 40) {
                shot.setLive(false);
                enemyTank_.setLive(false);
                // 创建一个bomb对象, 加入到集合之中, 这里添加之后就会有一个好处可以直接判段, 集合中有没有对象, 直接画出来
                Bomb bomb = new Bomb(enemyTank_.getX(), enemyTank_.getY());
                bombs.add(bomb); // 添加到集合之中
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (hero.getShot() != null && hero.getShot().isLive()) {
                /* 这样写的话后面的repaint方法就不会正常运行, 为什么
                    while (enemyTanks.iterator().hasNext()) {
                    EnemyTank next = enemyTanks.iterator().next();
                    stocked(hero.getShot(), next);
                }*/
                for (int i = 0; i < enemyTanks.size(); i++) {
                    stocked(hero.getShot(), enemyTanks.get(i));
                }
            }
            // 我感觉再这里写
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                EnemyTank.MoveFreely(enemyTank);
            }
            this.repaint();
        }
    }
}