package Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/16 - 09 - 16
 * @Description: Day15
 */
public class USBTest {
    public static void main(String[] args) {

        Computer test = new Computer();
        // 1. 创建了非匿名实现类的非匿名对象
        Flash flash = new Flash();
        test.transferDate(flash);
        System.out.println();
        // 2. 创建了非匿名实现类的匿名对象
        test.transferDate(new Flash());
        System.out.println();

        // 3.创建了匿名实现类的非匿名对象
        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("使用手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("使用手机结束工作");
            }
        };
        test.transferDate(phone);
        System.out.println();

        // 4.创建了匿名实现类的匿名对象
        test.transferDate(new USB() {
            @Override
            public void start() {

                System.out.println("MP3开始听歌");
            }

            @Override
            public void stop() {
                System.out.println("mp3结束听歌");

            }
        });
    }
}

interface USB {
  // 定义了长宽高和最小, 最大速度
    void start ();
    void stop ();
}


class Computer {

    public void transferDate (USB usb) {

        usb.start();
        System.out.println("具体细节");
        usb.stop();
    }
}
class Flash implements USB {


    @Override
    public void start() {
        System.out.println("u盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("u盘停止工作");

    }
}