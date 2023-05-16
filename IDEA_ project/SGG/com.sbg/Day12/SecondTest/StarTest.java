package Day12.SecondTest;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/17 - 09 - 17
 * @Description: SecondTest
 */
public class StarTest {
    public static void main(String[] args) {
        Star star = new realStar();
        Proxy proxy = new Proxy(star);
        proxy.bookTicket();
        proxy.collectMoney();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();


    }
}


interface Star {

    void sing(); // 唱歌

    void signContract();// 签合同

    void bookTicket(); // 订票

    void collectMoney(); // 收钱
}

class realStar implements Star{


    @Override
    public void sing() {
        System.out.println("明星唱歌 ~~ ");
    }

    @Override
    public void signContract() {

    }

    @Override
    public void bookTicket() {

    }

    @Override
    public void collectMoney() {

    }
}

class Proxy implements Star {

    private Star star;

    public Proxy(Star star) {
        this.star = star;
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void signContract() {
        System.out.println("经纪人签合同");

    }

    @Override
    public void bookTicket() {
        System.out.println("经纪人订票");

    }

    @Override
    public void collectMoney() {
        System.out.println("经纪人收钱");

    }
}