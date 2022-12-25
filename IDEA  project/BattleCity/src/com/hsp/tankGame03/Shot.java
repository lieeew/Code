package com.hsp.tankGame03;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/22 - 12 - 22
 * @Description: com.hsp.tankGame03
 */
public class Shot implements Runnable{
    private String position = "W";
    private int x;
    private int y;
    private int speed = 1;
    private boolean isLive = true;

    public Shot(int x, int y, String position) {
        this.x = x;
        this.y = y;
        this.position = position;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLive() {
        return isLive;
    }

    @Override
    public void run() {// 子弹运行
        while (true) {
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isLive = false;
                System.out.println("子弹由于碰倒墙壁, 消失");
                break;
            }
            switch (position) {
                case "W":
                    y -= speed;
                    break;
                case "S":
                    y += speed;
                    break;
                case "A":
                    x -= speed;
                    break;
                case "D":
                    x += speed;
                    break;
            }
            System.out.println("子弹的 x = " + x + "  y = " + y);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
