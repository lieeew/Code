package Day10;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/8/17 - 08 - 17
 * @Description: Day10
 */
public class AnimalTest { // 高内聚低耦合
    public static void main(String[] args) {
        Animal test = new Animal();
        // test.legs = 10; 不能直接调用
        test.setLegs(13);
        int a = test.getLegs();
        System.out.println(a);
        test.age = 10;
        test.name = "huahua";
        test.getInformaton();

    }
}
class Animal {
    private int legs;
    String name;
    int age;
    public void setLegs (int a) {// 封装性的一个体现不等同于封装性
        if (a > 0 && a % 2 == 0) {
            legs = a;
        }else {
            legs = -1;
        }
    }
    public int getLegs () {
        return legs;
    }
    public void getInformaton () {
        System.out.println("姓名:" + name + "\t年龄:" + age  + "\t个数:" + legs);
    }

}
