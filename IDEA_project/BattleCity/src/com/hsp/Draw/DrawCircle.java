package com.hsp.Draw;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.Draw
 * 画一个圆
 */

/*
这个列要继承与 JFrame 相当与一个画框
 */
public class DrawCircle extends JFrame{
    private MyPanel myPanel = null;

    public DrawCircle () {
        // 初始话一个面板
        myPanel = new MyPanel();
        // 把画笔放到画框里面
        this.add(myPanel);
        // 设置窗口的大小
        this.setSize(400, 300);
        // 设置为可以显示
        this.setVisible(true);
        // 设置关闭窗口退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new DrawCircle();
    }
}

// 1 先定义一个MyPanel, 继承与JPanel类 后面画图形会在这里画
class MyPanel extends JPanel {

    /**
     * Graphics 有很多方法
     * g 理解为画笔
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g); // 调用父类的构造器用于初始化
        // 画一个圆形
        g.drawOval(10, 10, 100, 100);
    }
}
