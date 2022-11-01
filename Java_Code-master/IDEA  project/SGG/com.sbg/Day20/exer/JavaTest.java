package Day20.exer;

import Day20.study.Person;

import java.sql.SQLOutput;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/23 - 10 - 23
 * @Description: Day20.exer
 */
public class JavaTest {
    public static void main(String[] args) {
        String s = "   w  d  e  h  g   ";
        Method method = new Method();
        String s1 = method.trimTest(s);
        System.out.println(s1);

        String s2 = "abcdefg";
        String s3 = method.exchangeMethod(s2, 2, 5);
        System.out.println(s3);
    }
}


class Method {

    public String trimTest(String s) {
        int start = 0;
        int end = s.length() - 1;

        if (s != null) {
            while (start < end && s.charAt(start) == ' ') {
                start++;
            }
            while (end > start && s.charAt(end) == ' ') {
                end--;
            }

            return s.substring(start , end + 1); // 截取字符串的指定长度, 左闭右开
        }
        return null;
    }

    /**
     * 把abcdefg 变为 abfedcg
     *
     */

    public String exchangeMethod(String s, int start, int end) {
        char[] chars = s.toCharArray();

        for(int a = start, b = end; a < b; a++, b--) {
            char temp = chars[a];
            chars[a] = chars[b];
            chars[b] = temp;
        }

        return new String(chars);

    }
}