
package com.leikooo.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/1 10
 * @Description: // 转译字符\\
 */
public class RegExp02 {
    public static void main(String[] args) {
        String content = ".abc$(abc(.123(";
        // 匹配( ==> 使用\\(
        // 匹配. ==> 使用\\.
        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 : " + matcher.group(0));
        }
    }
}
