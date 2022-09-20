package Day15exer.Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/17 - 09 - 17
 * @Description: Day15
 */
public class StarTest {
    public static void main(String[] args) {

        Star star = new RealStar();
        Broker broker = new Broker(star);
        broker.DoSomething();


    }
}


interface Star {

    void confer(); // 面谈

    void signContract(); // 签合同

    void sing(); // 唱歌

    void collectMoney(); // 收钱

}
class RealStar implements Star {


    @Override
    public void confer() {

    }

    @Override
    public void signContract() {

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

     public void DoSomething () {

         collectMoney();
         confer();
         star.sing();
         signContract();

     }

     @Override
     public void confer() {
         System.out.println("经纪人面谈");

     }

     @Override
     public void signContract() {
         System.out.println("经纪人签合同");

     }

     @Override
     public void sing() {

     }

     @Override
     public void collectMoney() {
         System.out.println("经纪人收钱");
     }
 }