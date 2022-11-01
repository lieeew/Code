package MarkdownTest02;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/17 - 09 - 17
 * @Description: MarkdownTest02
 */
public class RealStarTest {
    public static void main(String[] args) {
        Star star = new RealStar();
        Broker broker = new Broker(star);
        broker.collectMoney();
        broker.signContract();
        broker.confer();
        broker.sing();


    }
}


interface Star {
    void confer();// 面谈

    void signContract();// 签合同

    void bookTicket();// 订票

    void sing();// 唱歌

    void collectMoney();// 收钱
}

class RealStar implements Star {



    @Override
    public void confer() {

    }

    @Override
    public void signContract() {

    }

    @Override
    public void bookTicket() {

    }

    @Override
    public void sing() {
        System.out.println("明星唱歌");

    }

    @Override
    public void collectMoney() {

    }
}




class Broker implements Star {

    private Star star;

    public Broker(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("谈合同");
    }

    @Override
    public void signContract() {
        System.out.println("签合同");

    }

    @Override
    public void bookTicket() {
        System.out.println("订机票");

    }

    @Override
    public void sing() {
        star.sing();

    }

    @Override
    public void collectMoney() {
        System.out.println("收钱");

    }
}