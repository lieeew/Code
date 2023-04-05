package com.hspedu.Test.A;

/**
 * @Author: qxy
 * @Date: 2023/4/3
 * @Description:
 */
public class HomeWork {
    public static void main(String[] args) {
        new CellPhone().alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("铃声响铃~");
            }
        });


    }
}

interface Bell {
    void ring();
}

class CellPhone {

    public void alarmClock(Bell bell) {
        bell.ring(); // 动态绑定
    }
}