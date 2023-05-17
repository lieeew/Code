package Day30exer;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类的属性和方法(重要)
 * @Auther: QiuXinYu
 * @Date: 2022/11/26 - 11 - 26
 * @Description: Day30exer
 */
public class ImportantTest {

    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> aClass = Class.forName("Day30exer.Person");

        // 创建运行时类的对象
        Person p = (Person)aClass.newInstance();
        // 获取类的属性 必须声明为public
        // 通常不使用这个方法
        Field id = aClass.getField("id");
        // 设置属性, set() 的第一个参数: 指明哪个对象的属性  第二个参数: 将此属性值设置为多少
        id.set(p, 1001);
        // 获取当前属性值, 获取哪个对象的实行值
        Object o = id.get(p);
        System.out.println(o);

    }

    /**
     * 如何操作运行时类的实例
     */
    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> aClass = Class.forName("Day30exer.Person");
        // 创建运行时类的对象
        Object o = aClass.newInstance();
        // 获取类的属性
        Field name = aClass.getDeclaredField("name");
        // 保证当前属性是可以访问的, 必须设置才可以访问
        name.setAccessible(true);
        // 调用属性的set() get()
        // 设置属性, set() 的第一个参数: 指明哪个对象的属性  第二个参数: 将此属性值设置为多少
        name.set(o, "Tom");
        // 获取当前属性值, 获取哪个对象的实行值
        System.out.println(name.get(o));
    }


    @Test
    public void test3() throws Exception {
        Class<?> aClass = Class.forName("Day30exer.Person");
        // 创建运行时类的对象
        Object o = aClass.newInstance();
        /*
        1. 指定某个方法: getDeclaredMethod()   参数1: 指明获取方法的名称  参数2： 指明获取方法的参数列表
         */
        Method display = aClass.getDeclaredMethod("display", String.class, int.class); // 这里传入的是int.class
        // 必须保证当前方法可以访问
        display.setAccessible(true);
        /*
        2. 调用方法invoke(); 参数1: 方法的调用者, 实例的对象 参数2: 给方法形参赋的实参
        invoke()的返回值即为对象类调用方法的返回值, 没有返回值就为null
         */
        Object dis = display.invoke(o, "Tom", 12);

        System.out.println(dis);
        System.out.println("***********静态方法的调用********");

        Method showDest = aClass.getDeclaredMethod("showDest", int.class, double.class);

        showDest.setAccessible(true);

        showDest.invoke(null, 12, 23.9);// 形参可以是 null, 因为Person的所有静态方法已经加载到堆中
        showDest.invoke(Person.class, 13, 32.9); // 形参也可以是 当前类.class
    }

    /**
     * 调用指定的构造器 (了解), 主要所使用newInstance()这个方法
     */
    @Test
    public void test4() throws Exception {
        Class<?> aClass = Class.forName("Day30exer.Person");

        // 创造当前运行时类的对象
        Constructor<?> Constructor = aClass.getDeclaredConstructor(String.class);
        // 必须保证当前方法可以访问
        Constructor.setAccessible(true);
        // 调用newInstance()
        Object tom = Constructor.newInstance("Tom".toString());
        System.out.println(tom);

    }

    @Test
    public void test() throws Exception {
        Class<?> aClass = Class.forName("Day30exer.Person");
        Object o = aClass.newInstance();
        Method info = aClass.getDeclaredMethod("info");
        System.out.println(info.invoke(o));

    }
}
