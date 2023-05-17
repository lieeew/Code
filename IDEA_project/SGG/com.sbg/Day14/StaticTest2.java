package Day14;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/8 - 09 - 08
 * @Description: Day14
 */
public class StaticTest2 {
    public static void main(String[] args) {
        Women.play();  // play
        Women.height = "170";
        Women w = new Women();
        w.eat();
        Women.dance();
    }
}
class Women {
    String name;
    int age;
    static String height;

    public void eat () {
        System.out.println("eat");
        study();
        play();
        System.out.println(height);

    }
    public void study () {
        System.out.println("study");
    }
    public static void play () {
        System.out.println("play");
        dance();
        // study (); // Non-static method 'study()' cannot be referenced from a static context
    }
    public static void dance () {
        System.out.println("dance");
        System.out.println(height); // 可以调用static类型的height
        // System.out.println(age); // 不可以
    }
    public void information () {
        System.out.println("name :" + name + ", height" + height);
    }
    public void info () {
        System.out.println(Women.height); // 省略的是Women. 而不是this.
    }

}
