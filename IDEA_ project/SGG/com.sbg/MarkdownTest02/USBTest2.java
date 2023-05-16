package MarkdownTest02;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/16 - 09 - 16
 * @Description: MarkdownTest02
 */
public class USBTest2 {
    public static void main(String[] args) {

        Computers test = new Computers();
        //  1. 创建了非匿名实现类的非匿名对象
        flash fl = new flash();
        test.transferDates(fl);
        System.out.println();
        //  2. 创建了非匿名实现类的匿名对象
        test.transferDates(new flash());
        System.out.println();

        // 3.创建了匿名实现类的非匿名对象
        Usb mp3 = new Usb() {
            @Override
            public void start() {
                System.out.println("mp3开始工作");
            }

            @Override
            public void stop() {
                System.out.println("MP3关闭工作");

            }
        };
        test.transferDates(mp3);
        System.out.println();
        // 4.创建了匿名实现类的匿名对象

        test.transferDates(new Usb() {
            @Override
            public void start() {
                System.out.println("开机");
            }

            @Override
            public void stop() {
                System.out.println("关机");
            }
        });
    }
}

class Computers {

    public void transferDates (Usb usb) {

        usb.start();
        System.out.println("中间细节");
        usb.stop();
    }
}

interface Usb {

    void start ();
    void stop ();

}

class flash implements Usb {

    @Override
    public void start() {
        System.out.println("开始传输数据");
    }

    @Override
    public void stop() {
        System.out.println("结束传输数据");
    }
}