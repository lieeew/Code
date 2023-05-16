package Day22.study;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/3 - 11 - 03
 * @Description: Day22.study
 */

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 1. jdk5.0新增的内容
 *  2. 通过使用 Annotation, 程序员
 * 可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 * 代码分析工具、开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
 * 3. 在JavaEE/Android中注解占据了更重要的角色，例如
 * 用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。
 *
 *  框架 = 注解 + 反射机制 + 设计模式
 *
 *  实例:
 *  示例一：生成文档相关的注解
 *  示例二：在编译时进行格式检查(JDK内置的个基本注解)
 *     @Override: 限定重写父类方法, 该注解只能用于方法
 *     @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的择
 *     @SuppressWarnings: 抑制编译器警告
 *
 *   示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 *
 *   自定义注解:
 *   1. 注解声明为 @interface
 *   2. 注解内部成员需要用value来定义
 *   3. 可以指定成员的默认值 用default来定义 age: String value() default "hello";
 *   4. 如果自定义的成员没有值表明这个是个标识作用
 *   5. 如果注解有成员变量, 那么在使用时需要赋值, 有默认值可以不赋值
 *
 *   自定义注解必须配上注解的信息处理流程(反射)才有意义。
 *
 *
 *   jdk 提供的 4种元注解 :
 *   元注解:对现有注解进行修饰的注解
 *
 * Retention 只能用于修饰一个 Annotation 定义, 用于指定该 Annotation 的生命
 * 周期, @Rentention 包含一个 RetentionPolicy 类型的成员变量, 使用
 * @Rentention 时必须为该 value 成员变量指定值:
 * 
 * Target
 * *****************一下不常用
 * Documented
 * Inherited
 *
 *
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person p = new Student();
        p.walk();

        ((Student) p).eat();


    }

    @Test
    public void test1() {
        Class studentClass = Student.class;
        Annotation[] annotations = studentClass.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }

    }
}


////@MyAnnotation(value = "hi") // 由Target来规定修饰的范围
////@MyAnnotation(value = "hello");
class Person {
    @MyAnnotation(value = "hi")
    public void walk() {
        System.out.println("人走路");
    }
}

class Student extends Person {
    @Override
    public void walk() {
        System.out.println("学生走路");
    }
    @SuppressWarnings({})
    public void eat() {
        System.out.println("干饭");
    }
}

class Generic <T> {
    public void show() {
        ArrayList< @MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10;

    }
}
