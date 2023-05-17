package Day28;

import org.junit.Test;

import java.io.*;

/**
 *
 * 序列化和反序列化
 * ObjectInputStream和OjbectOutputSteam
 * 优点 :用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可
 * 以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *
 * @Auther: QiuXinYu
 * @Date: 2022/11/21 - 11 - 21
 * @Description: Day28
 */
public class ObjectInputOutputTest {
    /**
     * 序列化 : 将内存中java的对象保存到磁盘或通过网络传输
     * 使用ObjectOutputStream实现
     */
    @Test
    public void ObjectOutputStreamTest() {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));

            oos.writeObject(new String("我爱学习Java"));

            oos.flush(); // 刷新操作
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 反序列化 : 将磁盘中的文件还原为java内存中的对象
     * ObjectInputStream
     */
    @Test
    public void ObjectInputStreamTest() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));

            Object o = ois.readObject();
            String str = (String) o;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 自定义的类的序列化
     * ObjectOutputStream
     */
    @Test
    public void test3() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("data.dat"));

            oos.writeObject(new Person("lihua", 12));
            oos.flush(); // 刷新

            oos.writeObject(new String("你好java"));
            oos.flush();

            oos.writeObject(new Person("Mock", 13, new Account(1000)));
            oos.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 反序列化
     * ObjectInputStream
     */
    @Test
    public void test4() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("data.dat"));

            Person person = (Person) ois.readObject();
            System.out.println(person);

            String s = (String) ois.readObject();
            System.out.println(s);

            Person person1 = (Person) ois.readObject();
            System.out.println(person1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
 }
