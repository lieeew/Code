package Day15exer.Day15erro;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/22 - 09 - 22
 * @Description: Day15erro
 */


/**
 * Error ：
 * Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源
 * 耗尽等严重情况。比如：StackOverflowError和OOM。
 *  一般不编写针对性的代码进行处理。
 *
 */
public class ErrorTest {
    public static void main(String[] args) {
// java.lang.StackOverflowError
        main(args);

// java.lang.NegativeArraySizeException
        Integer[] arr = new Integer[13434 * 903893];
    }
}
