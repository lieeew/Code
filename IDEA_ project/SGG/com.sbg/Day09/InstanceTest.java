package Day09;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/11 - 08 - 11
 * @Description: Day09
 */
public class InstanceTest {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.sendEmail();
        p.playGame();
        // 匿名对象
        new Phone().price = 1999;
        System.out.println(new Phone().price); // 0.0
        PhoneMall mall = new PhoneMall();
        mall.show(new Phone());


    }
}
class PhoneMall{


    public void show(Phone phone){
        phone.sendEmail();
        phone.playGame();
    }

}


class Phone{
    double price;//价格

    public void sendEmail(){
        System.out.println("发送邮件");
    }

    public void playGame(){
        System.out.println("玩游戏");
    }

    public void showPrice(){
        System.out.println("手机价格为：" + price);
    }

}

