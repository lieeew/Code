package Day15exer;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/18 - 09 - 18
 * @Description: Day15exer
 */

/**
 * 如果父类和接口中有同名的方法同参数的方法分, 在子类没有重写的情况下 , 默认调用父类的方法
 *
 */
public class SubClassTest {
    public static void main(String[] args) {
        SubClass test = new SubClass();
        // 可以通过对象来调用默认方法
        test.method2();
        test.method3();
        // 通过 接口名 . 方法 来调用
        InterFace.method1();
        // 实现类重写了接口的默认方法, 运行时运行重写后的方法
        test.method3(); // Compare A jia
        // 如果父类和接口中有同名的方法同参数的方法分, 在子类没有重写的情况下 , 默认调用父类的方法



    }
}

class SubClass extends SuperClass implements InterFace {

    public  void method2 () {
        System.out.println("Compare A jia");

    }
    public void method4 () {
        method3();
        super.method3();
        // 调用接口中的默认方法
        InterFace.super.method2();
        InterFace.super.method3();


    }
}