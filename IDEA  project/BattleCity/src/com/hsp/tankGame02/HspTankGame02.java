package com.hsp.tankGame02;

import javax.swing.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.tankGame
 */
public class HspTankGame02 extends JFrame {
    private MyPanel myPanel = null;

    public HspTankGame02() {
        myPanel = new MyPanel();
        this.add(myPanel); // 添加画笔
        this.setSize(1000, 750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(myPanel);
    }

    public static void main(String[] args) {
        HspTankGame02 hspTankGame02 = new HspTankGame02();

    }
}
