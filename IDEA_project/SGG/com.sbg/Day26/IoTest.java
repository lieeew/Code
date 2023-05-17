package Day26;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/15 - 11 - 15
 * @Description: Day26
 */

/**
 * 1. 如何创建File的实例
 *   File(String pathname)
 *   File(String parent,String child)
 *   File(File parent,String child)
 *
 * 2. 相对路径: 相较于某一路径
 *    绝对路径: 包括盘符在内的文件或文件目录的路径
 *
 *路径分隔符
 * windows :\\
 * unix :/
 *
 * 3 相关方法涉及到文件后文件目录的创建, 删除, 重命名, 修改时间, 大小等.
 * 但没有涉及到, 写入或读取文件内容的操作, 如果需要的话, 可以通过IO流来实现
 * 4 后续File类的对象, 常会作为参数传递到流的构造器中, 指明写入或写出的"终点"
 */
public class IoTest {
    public static void main(String[] args){
        // 构造器1
        File file1 = new File("Hello.txt");
        File file2 = new File("E:\\CODE\\JAVA\\Java_Code-master\\IDEA  project\\SGG\\com.sbg\\Day26");

        System.out.println(file1);
        System.out.println(file2);

        // 构造器2
        File file3 = new File("E:\\CODE\\JAVA\\Java_Code-master", "IDEA  project");
        File file = new File("d:" + File.separator + "CODE" + File.separator + "JAVA");

        // 构造器3
        File file4 = new File(file3, "SGG");
        System.out.println(file3);
        System.out.println(file4);
    }

    /**
     *  File类的获取功能
     *  public String getAbsolutePath()：获取绝对路径
     *  public String getPath() ：获取路径
     *  public String getName() ：获取名称
     *  public String getParent()：获取上层文件目录路径。若无，返回null
     *  public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     *  public long lastModified() ：获取最后一次的修改时间，毫秒值
     *  public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
     *  public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void test1() {
        File file1 = new File("E:\\CODE\\JAVA\\IO");
        File file2 = new File("hello.text");

        File absoluteFile = file1.getAbsoluteFile(); // 获取绝对路径
        String parent = file1.getParent();
        String name = file1.getName();
        String parent1 = file1.getParent(); // 获取上层文件目录路径。若无，返回null
        long length = file1.length();
        long l = file1.lastModified();
        String[] list = file1.list();
        File[] files = file1.listFiles();

        System.out.println(absoluteFile);
        System.out.println(parent);
        System.out.println(name);
        System.out.println(parent);
        System.out.println(parent1);
        System.out.println(new Date(l));
        System.out.println(length);

        System.out.println();

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getParent());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));

    }

    @Test
    public void test2() {
        File file1 = new File("E:\\CODE\\JAVA\\Java_Code-master");
        String[] list = file1.list();
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file1.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    /**
     * File类的重命名功能
     *  public boolean renameTo(File dest):把文件重命名为指定的文件路径(文件名也需要写xxx.text)
     * 例如: file1.renameTo(file2) 要想返回的是true, 需要file1在硬盘中存在, file2硬盘中不存在
     */
    @Test
    public void test3() {
        File file1 = new File("hello.text");
        File file2 = new File("E:\\CODE\\JAVA\\IO\\hi.text");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }

    /**
     * File类的判断功能
     *  public boolean isDirectory()：判断是否是文件目录
     *  public boolean isFile() ：判断是否是文件
     *  public boolean exists() ：判断是否存在 推荐先进行判断是否存在
     *  public boolean canRead() ：判断是否可读
     *  public boolean canWrite() ：判断是否可写
     *  public boolean isHidden() ：判断是否隐藏
     */
    @Test
    public void test4() {
        File file1 = new File("hello.text");
        file1 = new File("ni.text");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists()); // 推荐先进行判断是否存在
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("E:\\CODE\\JAVA\\IO");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }

    /**
     * File类的创建功能
     *  public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
     *  public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     *  public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
     * 注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。
     *
     * File类的删除功能
     *  public boolean delete()：删除文件或者文件夹
     * 删除注意事项：
     * 1.Java中的删除不走回收站。
     * 2.要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
     */
    @Test
    public void test5() throws IOException {
        File file1 = new File("E:\\CODE\\JAVA\\IO\\helloWorld.txt");
        if (!file1.exists()) {
            // 创建
            file1.createNewFile();
            System.out.println("添加成功");
        } else {
            file1.delete();
            System.out.println("删除成功");
        }
    }

    /**
     *   public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。
     *  如果此文件目录的上层目录不存在，也不创建。
     *  public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
     *  注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。
     */
    @Test
    public void test6() {
        File file1 = new File("E:\\CODE\\JAVA\\IO\\IO1");
        boolean mkdir = file1.mkdir();
        if (mkdir) {
            System.out.println("创建成功");
        } else {
            System.out.println("False");
        }
    }
    @Test
    public void test7() {
        File file1 = new File("E:\\CODE\\JAVA\\IO\\IO1\\IO2");
        boolean mkdir = file1.mkdirs();
        if (mkdir) {
            System.out.println("创建成功");
        } else {
            System.out.println("False");
        }
    }
}
