package Day26;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/16 - 11 - 16
 * @Description: Day26
 */
public class FileDemo {
    /**
     * 利用File构造器，new 一个文件目录file
     * 1)在其中创建多个文件和目录
     * 2)编写方法，实现删除file中指定文件的操作
     */
    @Test
    public void test1() throws IOException {
        File file1 = new File("E:\\CODE\\JAVA\\IO\\IO1");
        File file2 = new File("E:\\CODE\\JAVA\\IO\\IO1", "haha.text");
        boolean exists = file2.exists();
        if (! exists) {
            file2.createNewFile();
            System.out.println("成功");
        }
    }

    /**
     * 删除指定的元素
     */
    @Test
    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件名:");
        String input = sc.next();
        File file = new File("E:\\CODE\\JAVA\\IO");
        String[] list = file.list();
        for (int i = 0; i < list.length; i++) {
            if (input.equals(list[i])) {
                File file1 = new File(file, list[i]);
                boolean delete = file1.delete();
                if (delete) {
                    System.out.println("删除成功!");
                } else {
                    System.out.println("删除失败!");
                }
            }
        }
    }

    /**
     * 判断指定目录下是否名有后缀为.jpg的文件，如果有，就输出该文件名称
     */
    @Test
    public void test3() {
        File file = new File("E:\\CODE\\JAVA\\IO\\IO1");
        String[] files = file.list();
        for (String str : files) {
            if (str.endsWith(".jpg")) {
                System.out.println(str);
            } else {
                System.out.println("未找到");
            }
        }
    }

    /**
     * 遍历指定目录所有文件名称，包括子文件目录中的文件。
     * 拓展1：并计算指定目录占用空间的大小
     * 拓展2：删除指定文件目录及其下的所有文件
     */
    @Test
    public void test4() {
        File file = new File("E:\\CODE\\JAVA\\IO\\IO1\\IO2");
        Ergodic(file);
    }

    public void Ergodic(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                Ergodic(f);
            }
        }
        file.delete();
    }




    @Test
    public void test5() {
        File file = new File("E:\\CODE\\JAVA\\IO\\IO1");
        System.out.println(acountAll(file));

    }
    private static int sum = 0;
    public static int acountAll(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                acountAll(f);
            }
        }
        sum += file.length();
        return sum;
    }
}
