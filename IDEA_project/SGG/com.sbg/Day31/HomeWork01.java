package Day31;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/12/5 - 12 - 05
 * @Description: Day31
 */
public class HomeWork01 {

    @Test
    public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // 1. 获取class对象
        Class<?> aClass = Class.forName("Day31.PrivateTest");
        // 2. 创建对象实例
        Object o = aClass.newInstance();
        // 3. 获取方法
        Field name = aClass.getDeclaredField("name");
        // 4. 爆破
        name.setAccessible(true);
        name.set(o,"邱鑫雨");
        // 获取方法
        Method getName = aClass.getDeclaredMethod("getName", null);
        // 可以不用爆破
        // getName.setAccessible(true);
        Object invoke = getName.invoke(o, null);
        System.out.println(invoke);

    }

    @Test
    public void test2() throws Exception {
        Class<?> aClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor cons : declaredConstructors) {
            System.out.println(cons);
        }

        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        String filePatch = "E:\\mytxt.txt";
        Object match = declaredConstructor.newInstance(filePatch);
        Method createNewFile = aClass.getDeclaredMethod("createNewFile");
        createNewFile.setAccessible(true);
        createNewFile.invoke(match, null);
        System.out.println("创建成功!");
    }

    @Test
    public void test3() throws Exception {
        Class<?> aClass = Class.forName("java.io.File");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        Object o = declaredConstructor.newInstance("E:\\helloWorld.txt");
        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(o);
        System.out.println("创建成功!");

    }
}

class PrivateTest {
    private String name = "helloKitty";

    public PrivateTest() {
    }

    public String getName () {
        return name;
    }

    @Override
    public String toString() {
        return "PrivateTest{" +
                "name='" + name + '\'' +
                '}';
    }
}
