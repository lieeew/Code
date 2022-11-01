package Day22.study;

import org.junit.Test;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/31 - 10 - 31
 * @Description: Day22.study
 */
public class OtherTest {

    @Test
    public void SystemTest() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);

    }

    @Test
    public void MatchTest() {

    }
}
