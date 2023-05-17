package com.hsp.event_;

import org.jetbrains.annotations.NotNull;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.event_
 */
public class BallMove extends JFrame{
    private DrawPanel drawPanel = null;
    public BallMove() {
        drawPanel = new DrawPanel();
        this.setSize(400, 500);
        this.add(drawPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(drawPanel); // drawPanel实现类接口, 可以直接通过多态进行操作
    }
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }
}

/*
KeyListener 是监听器, 可以监听键盘
 */
class DrawPanel extends JPanel implements KeyListener {
    private int x = 10;
    private  int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g. fillOval(x, y, 100, 100);
    }

    // 有字符输入时就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    // 有按键被按下时就会被触发
    @Override
    public void keyPressed(@NotNull KeyEvent e) {
        // 根据用户输入的不同来执行
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        }

        // 刷新
        this.repaint();
    }
    // 有按键释放(松开)后执行
    @Override
    public void keyReleased(KeyEvent e) {

    }
}