package Day30;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/24 - 11 - 24
 * @Description: Day30
 */
public class ReflectionTest {

    /**
     * 反射之前
     */
    @Test
    public void test1() {
        //1. person类的实例化
        Person p1 = new Person("Tom", 12);
        // 2.调用内部的属性和方法
        p1.age = 20;
        p1.show();
        // 在Person类的外部, 不能通过Person的对象调用内部的是私有化的结构
        // 比如, name, showNation()
    }

    /**
     * 反射
     * 通过直接new和反射否可以调用公共的结构, 开发中用那一个
     * 建议 : 直接new
     *
     * 反射机制和面向对象的封装性有没有矛盾>
     * 没有矛盾, 私有化也有公开的, 公开的已经调用私有化的比并且加入了其他逻辑
     * 反射: 可以调用
     * 封装: 建不建议调
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{
        Class aClass = Person.class;
        Constructor constructor = aClass.getConstructor(String.class, int.class);
        // 1. 通过反射创建对象
        Object tom = constructor.newInstance("Tom", 12); //
        System.out.println(tom);

        // 2. 通过反射调用属性和方法
        Field age = aClass.getDeclaredField("age");
        age.set(tom,10);
        System.out.println(tom);

        Method show = aClass.getDeclaredMethod("show");
//        show.invoke(12);


    }

    @Test
    public void test3() throws ClassNotFoundException {
        // 如何获取Class类的实例 在一段时间内，
        // 方式一: 调用运行时类的属性.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        // 方式二: 调用运行时类的对象的 getClass() 方法
        Person p1 = new Person();
        Class<? extends Person> aClass = p1.getClass();
        System.out.println(aClass);
        // 方式三： 调用Class的静态方法： forName（String classPatch）
        Class<?> aClass1 = Class.forName("java.lang.String");
        System.out.println(aClass1);

        // 方式四 使用类的加载器 ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> aClass2 = classLoader.loadClass("java.lang.String");
        System.out.println(aClass2 == aClass1);


    }

    @Test
    public void test5() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;


        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}
