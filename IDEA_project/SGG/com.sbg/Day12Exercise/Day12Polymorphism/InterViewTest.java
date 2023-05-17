package Day12Exercise.Day12Polymorphism;

import java.util.Random;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/2 - 09 - 02
 * @Description: Day12Polymorphism
 */
public class InterViewTest {
    public static  Animal1 getInstance (int key) {
        switch  (key) {
            case 1 :
                return new Cat();
            case 2 :
                return new Dog();
            default:
                return new sheep();
        }
    }

    public static void main(String[] args) {
        int key = new Random() .nextInt(3);
        System.out.println(key);
        Animal1 animal1 = getInstance(key);
        animal1.Eat();
    }

}
class Animal1 {
    public void Eat () {
        System.out.println("eat");
    }
}
class Dog extends Animal1{
    public void Eat() {
        System.out.println("Dog eat bone");
    }
}
class Cat extends Animal1{
    public void Eat () {
        System.out.println("Eat fish");
    }
}
class sheep extends Animal1{
    public void Eat () {
        System.out.println("sheep");
    }
}
