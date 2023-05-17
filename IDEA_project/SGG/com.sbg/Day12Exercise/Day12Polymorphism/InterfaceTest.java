package Day12Exercise.Day12Polymorphism;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/15 - 09 - 15
 * @Description: Day15
 */
public class InterfaceTest {
    public static void main(String[] args) {

        Kite kite = new Kite();
        kite.fly();
        kite.stop();


    }
}


interface Fly {

    public static final int MAX_SPEED = 1400; // public static final 可以省略
    public static final int MIN_SPEED = 1;

    public abstract void fly ();
    void stop();

}
 class Kite implements Fly {

    @Override
    public void fly() {
        System.out.println("飞机加速");

    }

     @Override
     public void stop() {
         System.out.println("让飞机停下来");
     }
 }

 class Plane extends Kite {


     @Override
     public void stop() {
         System.out.println("飞机起飞了");
     }
 }

 interface AA {

    void eat();
 }

 interface BB {

    void study();
 }
 interface CC extends AA, BB {

 }
