package com.qxy.MyIdea.tankGame02;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/19 - 12 - 19
 * @Description: com.hsp.tankGame
 */
public class Tank {
    private int x; // 坦克的横坐标
    private int y; // 坦克的纵坐标
    private String direction = "W"; // 竟然可以定义一个属性, 注意啦

    private int speed = 1;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // 坦克上下左右的方法, 体现封装性
    public void moveUp () {
        y -= speed;
    }
    public void moveDown() {
        y += speed;
    }
    public void moveRight() {
        x += speed;
    }
    public void moveLeft() {
        x -= speed;
    }
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
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
}
