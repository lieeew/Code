package Day30exer;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构(用得少)
 * @Auther: QiuXinYu
 * @Date: 2022/11/25 - 11 - 25
 * @Description: Day30exer
 */
public class FileTest {

    @Test
    public void test1() {
        Class<Person> personClass = Person.class;
        // 获取属性结构
        // getFields(): 获取当前类和父类中说明的为public访问权限的属性
        Field[] fields = personClass.getFields();
        for (Field file : fields) {
            System.out.println(file);
        }
        System.out.println();
        // getDeclaredFields(): 获取当运行时类中声明的所有属性(不包括父类声明的属性)
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }

    /**
     * 权限修饰符
     * 数据类型
     * 变量名
     */
    @Test
    public void test2() {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getDeclaredFields();

        for (Field f : fields) {
            // 1. 权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //2 数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            // 3 变量名
            String name = f.getName();
            System.out.print(name + "\t");
            System.out.println();
        }
    }

    @Test
    public void test3() {
        Class<Person> personClass = Person.class;
        // getMethods(): 获取当前类和父类的所有声明为public的方法
        Method[] methods = personClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println();
        // getDeclaredMethods(): 获取当运行时类中声明的所有方法(不包括父类声明的方法)
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
    }

    /**
     * 方法:
     * @Xxxx
     * 权限修饰符 返回值 方法名 (形参) throws Xxxx{}
     */
    @Test
    public void test4() {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        // 注解, 声明周期必须得够 @Retention(RetentionPolicy.RUNTIME)
        for (Method m : methods) {
            Annotation[] annotations = m.getDeclaredAnnotations();
            for (Annotation anna : annotations) {
                System.out.println(anna + "\t");
            }
            // 权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");
            // 返回值
            System.out.print(m.getReturnType().getName() + "\t");
            // 方法名
            System.out.print(m.getName() + "\t");
            // 参数列表
            System.out.print("(");

            Class<?>[] parameterTypes = m.getParameterTypes(); // 获取参数类型
            if (!(parameterTypes == null || parameterTypes.length == 0)) { // 逻辑运算符写错了，&&是短路与，第一项为true，会去判断第二项，应该用||短路或，如果第一项为true，第二项就不会再判断
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + "args_" + i );
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + "args_" + i + ",");
                }
            }

            System.out.print(")");
            // 获取异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes == null || exceptionTypes.length == 0)) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

            System.out.println();
        }
    }
}
