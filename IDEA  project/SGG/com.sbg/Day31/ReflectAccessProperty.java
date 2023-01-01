package Day31;

import java.lang.reflect.Field;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/4 - 12 - 04
 * @Description: Day31
 */
public class ReflectAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> student = Class.forName("Day31.Student");
        Object o = student.newInstance();
        // 反射获取属性
        Field age = student.getDeclaredField("age");
        age.setAccessible(true);
        age.set(o, 12);
        System.out.println(o);

        // 获取static private 对象
        Object o1 = student.newInstance();
        Field name = student.getDeclaredField("name");
        name.setAccessible(true);
        name.set(null, "李华"); // 静态调用会直接加载
        System.out.println(o1);

        System.out.println(age.get(o)); // 获取属性
        System.out.println(name.get(null)); // name要求是静态的
    }
}

