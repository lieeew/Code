package Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/16 - 09 - 16
 * @Description: Day15
 */
public class USBTest {
    public static void main(String[] args) {

        Computer test = new Computer();
        Flash flash = new Flash();
        test.transferDate(flash);
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