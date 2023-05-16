package com.hsp.tankGame01;

import javax.swing.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.tankGame
 */
public class HspTankGame01 extends JFrame {
    private MyPanel myPanel = null;

    public  HspTankGame01() {
        myPanel = new MyPanel();
        this.add(myPanel); // 添加画笔
        this.setSize(1000, 750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        HspTankGame01 hspTankGame01 = new HspTankGame01();

    }
}
