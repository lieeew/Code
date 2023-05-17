package Day11;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/29 - 08 - 29
 * @Description: Day11
 */
public class Students extends Person{
    public void Study () {
        System.out.println("学习");
    }

    public static void main(String[] args) {
        Students S = new Students();
        S.eat();
        S.Study();
        S.setSex('女');
        char sex = S.getSex();
        System.out.println(sex);

    }
}
