package Day15erro;

import org.junit.Test;

/**
 * @Auther: qiuxinyu
 * @Date: 2022/9/23 - 09 - 23
 * @Description: Day15erro
 */
public class ExceptionTest2Test {

    @Test
    public void test() {
        String str = "123";
        str = "abc";
        try{
            int i = Integer.parseInt(str);
            System.out.println("hello --- 1");
        } catch (NumberFormatException e) {
            System.out.println("出现数值转化异常~~~");

            // 常用方法
            // System.out.println(e.getMessage());  // For input string: "abc"

            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("出现空指针异常~~~");
        } catch (Exception e) {
            System.out.println("异常~~");
        }
        System.out.println("hello --- 2");
        // System.out.println(i);

    }

}