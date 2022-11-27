package Day30;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/25 - 11 - 25
 * @Description: Day30
 */
public class ClassLoaderTest {

    @Test
    public void test1() {
        // 对于自定义类, 使用系统类的加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        // 使用系统类的加载器的getParent() :获取扩展类的加载器
        ClassLoader classLoader1 = classLoader.getParent();
        // 调用扩展类的加载器的getParent() : 无法获取引导类的加载器
        // 引导类的加载器主要负责加载java的核心类库: 无法加载自定义类
        ClassLoader parent = classLoader1.getParent();
        System.out.println(parent);

    }

    /**
     * Properties 用来读取配置文件
     */
    @Test
    public void test2() throws Exception {

        Properties properties = new Properties();
        // 方式一: 相对于当前的module下
//        FileInputStream inputStream = new FileInputStream("jdbc.Properties");
//
//        properties.load(inputStream);
        // 方式二 : 读取方式,默认识别与当前的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // 相对于当前的src
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.Properties");
        properties.load(resourceAsStream);

        String name = properties.getProperty("name");
        String passworld = properties.getProperty("passworld");
        System.out.println("name = " + name + ", passworld = " + passworld);

    }

    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("jdbc.Properties");
        properties.load(inputStream);

        String name = properties.getProperty("name");
        String passworld = properties.getProperty("passworld");
        System.out.println("name = " + name + ", passworld = " + passworld);
    }
}
