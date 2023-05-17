package Day15exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/19 - 09 - 19
 * @Description: Day15exer
 */

interface Final { // 孝顺的
    public default void help() {
        System.out.println("救你老妈");
    }
}

interface Spoony {
    default void help () {
        System.out.println("救你媳妇");
    }

}

class Father {
    public void help () {
        System.out.println("你说救谁");
    }
}
public class Man extends Father implements Final, Spoony{
    @Override
    public void help() {
        System.out.println("自生自灭");
    }


    public static void main(String[] args) {
        Man man = new Man();
        man.help();
    }
}
