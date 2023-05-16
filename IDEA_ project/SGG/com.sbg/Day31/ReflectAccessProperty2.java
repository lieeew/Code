package Day31;

import java.lang.reflect.Method;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/4 - 12 - 04
 * @Description: Day31
 */

/**
 *
 */
public class ReflectAccessProperty2 {
    public static void main(String[] args) throws Exception {
        Class<?> boss = Class.forName("Day31.Boss");
        Object o = boss.newInstance();

        Method hi = boss.getDeclaredMethod("hi", String.class);
        Object lihua = hi.invoke(o,"李华");
        System.out.println(o);

        Method say = boss.getDeclaredMethod("Say", int.class, String.class, char.class);
        say.setAccessible(true); // 需要爆破, 方式是私有的
        Object invoke = say.invoke(o, 12, "你好", 'A');
        Object invoke1 = say.invoke(null, 12, "你好", 'A'); // 因为是static 可以把对象设置为null
        System.out.println(invoke);
        /*
        在放射中invoke()返回值都是Object, 但是运行类型和方法一致
         */
        Object returnCla = say.invoke(null, 100, "王五", '男');
        System.out.println("returnCla 的运行类型: " + returnCla.getClass()); // String

    }
}

class Boss {
    private int age;
    private static String name;

    public Boss() {
    }

    public Boss(int age) {
        this.age = age;
    }

    private static String Say(int a, String b, char c) {
        return a + b + c;
    }

    public void hi(String s) {
        System.out.println("hi : " + s);
    }

    @Override
    public String toString() {
        return "Boss{" +
                "age=" + age +
                '}';
    }
}