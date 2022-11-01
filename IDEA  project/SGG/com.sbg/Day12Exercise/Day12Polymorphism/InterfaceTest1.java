package Day12Exercise.Day12Polymorphism;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/15 - 09 - 15
 * @Description: Day15
 */
public class InterfaceTest1 {
    public static void main(String[] args) {


    }
}

interface Study {

    int hour = 20; // 学习时间
    void study ();

}

interface Play {

    void play ();
}

class Student extends Object implements Study, Play {


    @Override
    public void study() {
        System.out.println("学习到深夜");
    }

    @Override
    public void play() {
        System.out.println("学生也需要玩游戏");
    }
}