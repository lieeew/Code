package Day12Exercise.Day12Polymorphism;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/1 - 09 - 01
 * @Description: Day12Polymorphism
 */
public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest an = new AnimalTest();
        an.function(new dag());

    }
    public void function (Animal animal) {
        animal.eat();
        animal.shout();
    }
}
class Animal {
    public void eat () {
        System.out.println("动物进食");
    }
    public void shout (){
        System.out.println("动物叫");
    }

}
class cat extends Animal {
    @Override
    public void eat() {
        System.out.println("鱼");
    }

    @Override
    public void shout() {
        System.out.println("喵喵喵");
    }
}
class dag extends Animal {
    @Override
    public void eat() {
        System.out.println("狗粮");
    }

    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }
}
