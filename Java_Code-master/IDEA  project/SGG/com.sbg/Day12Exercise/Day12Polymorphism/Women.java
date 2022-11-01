package Day12Exercise.Day12Polymorphism;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/1 - 09 - 01
 * @Description: Day12Polymorphism
 */
public class Women extends Person{
    boolean isBeauty;
    public void goShopping () {
        System.out.println("女人喜欢购物");
    }
    public void eat () {
        System.out.println("less eat");
    }
    public void walk () {
        System.out.println("女人窈窕的走路");
    }
}
