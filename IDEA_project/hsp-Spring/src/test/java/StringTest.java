import com.hspedu.Spring.Annotation.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: StringTest
 * Package: PACKAGE_NAME
 *
 * @Author: leikooo
 * @Creat: 2023/6/1 - 8:19
 * @Description:
 */
public class StringTest {
    public static void main(String[] args) {
        String path = "execution(public float com.hspedu.Spring.component.SmartAnimal.getSum(float , float))";
        // execution(public float com.hspedu.Spring.component.SmartAnimal.getSum(float, float))
        System.out.println("path = " + path);
        String substring = path.substring(path.indexOf('(') + 1, path.lastIndexOf(')'));
        System.out.println("substring = " + substring);
        String s1 = substring.split(" ")[2];
        String s = s1.substring(s1.lastIndexOf('.'));

    }

    @Test
    public void test() {
        String str = "public float com.hspedu.Spring.component.SmartAnimal.getSum(float, float)";
        int lastIndex1 = str.lastIndexOf(" ");
        int lastIndex2 = str.lastIndexOf(".");
        String shortName = str.substring(0, lastIndex1);
        String fullName = str.substring(lastIndex2 + 1);
        System.out.println("fullName = " + fullName);
        System.out.println("shortName = " + shortName);

    }

    @Test
    public void test2() {
        String input = "public float com.hspedu.Spring.component.SmartAnimal.getSum(float, float)";

        // 使用正则表达式提取类名
        Pattern pattern = Pattern.compile("([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*([a-zA-Z_$][a-zA-Z\\d_$]*)\\(");
        Matcher matcher = pattern.matcher(input);

        // 找到匹配的类名
        if (matcher.find()) {
            // 获取完整的类名（包括包路径）
            String fullClassName = matcher.group(0);
            System.out.println("完整的类名（包括包路径）: " + fullClassName.trim().substring(0, fullClassName.lastIndexOf('.')));

            // 获取最后一个点之后的类名（不包括包路径）
            String className = matcher.group(2);
            System.out.println("类名: " + className);
        }
    }
}
