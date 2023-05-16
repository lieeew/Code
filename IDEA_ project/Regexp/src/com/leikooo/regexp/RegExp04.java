package com.leikooo.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/1 15
 * @Description: 选择匹配
 */
public class RegExp04 {
    public static void main(String[] args) {
        String content = "hanshunping 韩 寒冷";
        String regStr = "han|韩|寒";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到 : " + matcher.group(0));
        }
    }
}
