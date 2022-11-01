
package Day15exer.Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/15 - 09 - 15
 * @Description: Day15
 */
public class InterfaceTest2 {
    public static void main(String[] args) {

        Plane plane = new Plane();
        plane.Fly();

    }
}

interface Attack {

    void attack ();
}

interface Flyable {

    void Fly ();
    void Stop ();
}

class Plane implements Flyable {


    @Override
    public void Fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void Stop() {
        System.out.println("驾驶员降速停止");
    }
}

abstract class Kite implements Flyable {


    @Override
    public void Fly() {

    }
}

class Bullet  extends Object implements Flyable, Attack {


    @Override
    public void attack() {

    }

    @Override
    public void Fly() {

    }

    @Override
    public void Stop() {

    }

    public void play1() {

    }


    public void play2() {

    }
}

interface aa {

    void play1 ();
}

interface bb {

    void play2 ();
}