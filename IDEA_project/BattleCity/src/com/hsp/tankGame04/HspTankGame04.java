package com.hsp.tankGame04;

import javax.swing.*;


public class HspTankGame04 extends JFrame {
    private MyPanel myPanel = null;

    public HspTankGame04() {
        myPanel = new MyPanel();
        this.add(myPanel); // 添加画笔
        this.setSize(1000, 750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(myPanel);
        /*
        这个是一个单独的线程, 帮助让画面每个一段时间重新绘制, 这样之后就可以看到子弹的运行效果了
         */
        new Thread(myPanel).start();
    }

    public static void main(String[] args) {
        HspTankGame04 hspTankGame = new HspTankGame04();
    }
}
