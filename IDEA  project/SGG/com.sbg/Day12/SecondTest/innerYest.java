package Day12.SecondTest;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/19 - 09 - 19
 * @Description: SecondTest
 */
public class innerYest {
    public static void main(String[] args) {
        Biology.Pig pig = new Biology.Pig();
        pig.eat();

        Biology biology = new Biology();
        Biology.Bird bird = biology.new Bird();
        bird.Sing();

    }
}

class Biology {

    String name;
    int age;
    public void play () {
        System.out.println("生物玩游戏");
    }


    // 静态

    static class Pig {
        public void eat () {
            System.out.println("吃饭");
        }

    }
    // 非静态
    class Bird {

        String name;

        public void Sing() {
            System.out.println("唱歌");
        }
    }
}
