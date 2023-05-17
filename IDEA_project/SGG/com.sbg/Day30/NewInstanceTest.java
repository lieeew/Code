package Day30;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射调用运行时类的对象
 * @Auther: QiuXinYu
 * @Date: 2022/11/25 - 11 - 25
 * @Description: Day30
 */
public class NewInstanceTest {
   /*
   newInstance(): 调用此方法可以获取当前运行时类的对象 ,但是底层依然是调用构造器来创建对象

   要想此方法正常创建运行时类的对象, 要求:
   1. 运行时类必须提供空参构造器
   2. 空参构造器的权限必须得购

   在javabean中需要提供一个空参构造器, 原因?
   1. 便于通过反射创建运行时类的对象
   2. 便于子类调用super() 不会报错
    */
    @Test
    public void test1() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> person = Class.forName("Day30.Person"); // 需要指定具体的Person

        Person p = (Person) person.newInstance(); // newInstance(): 调用此方法可以获取当前运行时类的对象
        System.out.println(p);
    }


    @Test
    public void test2() {

        for (int i = 0; i < 100; i++) {
            int i1 = new Random().nextInt(3); //0 , 1, 2
            String classPatch = "";
            switch (i1) {
                case 0:
                    classPatch = "java.lang.String";
                    break;
                case 1:
                    classPatch = "java.util.Date";
                    break;
                case 2:
                    classPatch = "Day30.Person";
                    break;
            }
            Object instance = null;
            try {
                instance = getInstance(classPatch);
                System.out.println(instance);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
    // 体会反射的动态性
    public Object getInstance(String classPatch) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> aClass = Class.forName(classPatch);
        return aClass.newInstance();
    }
}
