package Day21.exer;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/26 - 10 - 26
 * @Description: Day21.exer
 */
public class suanfaTest {


    /**
     * 1.模拟一个trim方法，去除字符串两端的空格
     */
    public String test1(String s) {
        if(s != null) {
            int StartNum = 0;
            int EndNum = s.length() - 1;

           while (StartNum < EndNum && s.charAt(StartNum) == ' ') {
               StartNum++;
           }
           while (StartNum < EndNum && s.charAt(EndNum) == ' ') {
               EndNum--;
           }
            return s.substring(StartNum, EndNum + 1);
        }
        return null;
    }

    /**
     * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
     */
    public String reversTest(String s, int start, int end) {
        if (s != null) {
            char[] chars = s.toCharArray();

            for (int a = start, b = end; b > a; a++, b--) {
                char temp = chars[a];
                chars[a] = chars[b];
                chars[b] = temp;
            }
            return new String(chars);
        }
        return null;
    }

    public String reversTest2(String s, int start, int end) {
        if (s != null) {
            StringBuilder sb = new StringBuilder(s.length()); // 先创建一个固定长度的数组, 这样就不用扩容, 效率更高

            // 第一部分
            sb.append(s.substring(0, start));
            // 第二部分
            for (int i = end; i <= start; i--) {
                sb.append(s.charAt(i));
            }
            // 第三部分
            sb.append(s.substring(end + 1));

            return new String(sb);
        }
        return null;
    }

    /**
     *获取一个字符串在另一个字符串中出现的次数。
     *       比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”中出现的次数
     */
    public int test3(String s, String found) {
        int sum = 0;
        int index = 0;
        int mainLength = s.length();
        int subLength = found.length();
        if (mainLength > subLength) {
            // 方式一:
           /* while ((index = s.indexOf(found)) != -1) { // 循环判断
                sum++;
                s = s.substring(index + found.length()); // 运用变量思维, 进行重复判断, 可以不用递归
            }*/
            // 方式二:  不用修改字符串, 直接用指定位置的indexOf()指定位置查找
            while ((index = s.indexOf(found, index)) != -1) {// 当查找到index之前先赋值给后面的index
                sum++;
                index += subLength;
            }
            return sum;
        }
        return 0;
    }





    @Test
    public void test1() {
        suanfaTest suanfaTest = new suanfaTest();
        String s = "  a c v   ";
        String s1 = suanfaTest.test1(s);
        System.out.println(s1);

    }

    @Test
    public void test2() {
        suanfaTest suanfaTest = new suanfaTest();
        String s = "abcdefg";
        String s1 = suanfaTest.reversTest(s, 1, 5);
        System.out.println(s1);
    }

    @Test
    public void test3() {
        String s = "abcdabchiab";
        suanfaTest suanfaTest = new suanfaTest();
        int sum = suanfaTest.test3(s, "ab");
        System.out.println(sum);
    }
}
