package com.hsp.tankGame04;


/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/23 - 12 - 23
 * @Description: com.hsp.tankGame04
 * 坦克爆照类
 */
public class Bomb {
    private int x;
    private int y;
    private int leftTime = 18; // 剩余时间
    private boolean isLive = true;

    public int getLeftTime() {
        return leftTime;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void leftDown() {
        if (leftTime > 0) {
            leftTime--;
        } else {
            isLive = false;
        }
    }
}
