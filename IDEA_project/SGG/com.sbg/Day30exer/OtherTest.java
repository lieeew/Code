package Day30exer;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 构造器
 * @Auther: QiuXinYu
 * @Date: 2022/11/26 - 11 - 26
 * @Description: Day30exer
 */
public class OtherTest {

    @Test
    public void test1() {
        Class<Person> personClass = Person.class;
        // 获取本类中声明为public的构造器
        Constructor<?>[] constructors = personClass.getConstructors();
        for ( Constructor<?> c : constructors) {
            System.out.println(c);
        }
        System.out.println();
        // 获取本类中所有的构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for ( Constructor<?> c : declaredConstructors) {
            System.out.println(c);
        }
    }

    /**
     * 获取父类的不带泛型的构造器
     */
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
    }

    /**
     * 获取带泛型的父类
     */
    @Test
    public void test3() {
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /**
     * 获取带泛型的父类的泛型
     *
     * 逻辑性代码 VS 功能性代码
     */
    @Test
    public void test4() {
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = type.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]); // class java.lang.String
        // 获取不带class的
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class) actualTypeArguments[0]).getName());
    }

    /**
     * 获取运行实现类的接口
     * @throws ClassNotFoundException
     */
    @Test
    public void test5() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("Day30exer.Person");
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> c : interfaces) {
            System.out.println(c);
        }

        System.out.println("获取父类实现的接口");
        Class<?>[] interfaces1 = aClass.getSuperclass().getInterfaces();
        for (Class<?> c : interfaces1) {
            System.out.println(c);
        }
    }

    /**
     * 获取包名
     * @throws ClassNotFoundException
     */
    @Test
    public void test6() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("Day30exer.Person");
        Package aPackage = aClass.getPackage();
        System.out.println(aClass);
    }

    /**
     * 获取运行时类声明的注解
     * @throws ClassNotFoundException
     */
    @Test
    public void test7() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("Day30exer.Person");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
    }

}
