<<<<<<< HEAD
package Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/15 - 09 - 15
 * @Description: Day15
 */
public class InterfaceTest {
    public static void main(String[] args) {
        CC TEST = new DD();
        TEST.Fly();
        TEST.study();
    }
}


interface AA {

    void Fly ();
}

interface BB extends AA {
    void study ();
}

class CC implements AA, BB {

    @Override
    public void Fly() {
        System.out.println("飞起来");
    }

    @Override
    public void study() {
        System.out.println("学习");
    }
}

class DD extends CC implements AA, BB {

    @Override
    public void study() {
        System.out.println("nb");
    }
=======
package Day15;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/15 - 09 - 15
 * @Description: Day15
 */
public class InterfaceTest {
    public static void main(String[] args) {
        CC TEST = new DD();
        TEST.Fly();
        TEST.study();
    }
}


interface AA {

    void Fly ();
}

interface BB extends AA {
    void study ();
}

class CC implements AA, BB {

    @Override
    public void Fly() {
        System.out.println("飞起来");
    }

    @Override
    public void study() {
        System.out.println("学习");
    }
}

class DD extends CC implements AA, BB {

    @Override
    public void study() {
        System.out.println("nb");
    }
>>>>>>> 342d998f6a10552cde9b1c4b898aedb460705879
}