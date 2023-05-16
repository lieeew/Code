package Day13;



/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/1 - 09 - 01
 * @Description: Day12Polymorphism
 */
public class Man extends Person {
    boolean isSmoking;
    public void earnMoney () {
        System.out.println("男人负责挣钱养家");
    }
    public void eat () {
        System.out.println("男人多吃肉,长肌肉");
    }
    public void walk () {
        System.out.println("男人霸气走路");
    }
}
