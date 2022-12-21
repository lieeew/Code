package com.hsp.Draw;

import org.omg.CORBA.PRIVATE_MEMBER;
import sun.java2d.pipe.DrawImage;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.Draw
 */
/*
    常用方法测试
    画直线drawLine(intx1,inty1,intx2,inty2)
    画矩形边框drawRect(intX,inty,int width,int height)
    画椭圆边框drawOval(intx,inty,int width,int height)
    填充矩形fillRect(intx,inty,int width,int height)
    填充椭圆filloval(intx,inty,int width,int height)
    画图片drawlmage(Image img,intx,inty,…)
    画字符串drawString(String str,,intx,inty)
    设置画笔的字体setFont(Font font)
    设置画笔的领色setColor(Color c)
*/
public class DrawMethod extends JFrame {
    private DrawPanel drawPanel = null;
    public DrawMethod() {
        drawPanel = new DrawPanel();
        this.add(drawPanel);
        this.setSize(2000, 3000);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DrawMethod();
    }
}

class DrawPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        常用方法测试
//        画直线drawLine(intx1,inty1,intx2,inty2)
//        g.drawLine(10, 100, 40, 200);
//        画矩形边框drawRect(intX,inty,int width,int height)
//        g.drawRect(10, 10, 100, 100);
//        画椭圆边框drawOval(intx,inty,int width,int height)
//        g.drawOval(100, 100, 200, 100);
//        填充矩形fillRect(intx,inty,int width,int height)
        // 设置画笔颜色
       g.setColor(Color.cyan);
       g.fillRect(10, 10, 100, 100);
//        填充椭圆filloval(intx,inty,int width,int height)
//        g.fillOval(100, 100, 200, 100);
//        画图片drawlmage(Image img,intx,inty,…)
        // 1. 获取图片资源
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/gril.jpg"));
        g.drawImage(image, 10, 10, 1496, 2275, this);
//        画字符串drawString(String str,,intx,inty) // 写字
        // 1.给画笔设置颜色和字体
        g.setColor(Color.red);
        g.setFont(new Font("隶属", Font.BOLD, 50));
        // 这个xy对应的是坐下角
        g.drawString("COVID-19", 100, 200);
//        设置画笔的字体setFont(Font font)
//        设置画笔的领色setColor(Color c)
    }
}