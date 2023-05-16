package Day21.exer;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/10/26 - 10 - 26
 * @Description: Day21.exer
 */
public class suanfaTest2 {
    /**
     * 4.获取两个字符串中最大相同子串。比如：
     *    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
     *    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
     */
    public String getMaxSameSubString(String s1, String s2) {
        String MaxString = (s1.length() > s2.length()) ? s1 : s2;
        String MinString = (s1.length() < s2.length()) ? s1 : s2;
        int length = MinString.length();
        for (int i = 0; i < length; i++) {
            for (int a = 0, b = length - i; b >= length ; a++, b++) {
                if (MaxString.contains(MinString.substring(a, b))) {
                    return MinString.substring(a, b);
                }
            }
        }
        return null;
    }

    /**
     * 对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
     * 提示：
     * 1）字符串变成字符数组。
     * 2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
     * 3）将排序后的数组变成字符串。
     *
     */

    public String Sort(String s) {
        if (s != null) {
            char[] chars = s.toCharArray();

//            for (int a = 0; a < chars.length - 1; a++) {
//                for (int j = 0; j < chars.length - 1 -a; j++) {
//                    if (chars[j] > chars[j + 1]) {
//                        char temp = chars[j];
//                        chars[j] = chars[j + 1];
//                        chars[j +1] = temp;
//                    }
//                }
//            }
            Arrays.sort(chars);
            return new String(chars);
        }
        return null;
    }


    @Test
    public void test1() {
        String s1 = "abcdacnjac";
        String s2 = "abcd";
        String maxSameSubString = getMaxSameSubString(s1, s2);
        System.out.println(maxSameSubString);
    }

    @Test
    public void test2() {
        String s = "dcasbg";
        String sort = Sort(s);
        System.out.println(sort);
    }


}
