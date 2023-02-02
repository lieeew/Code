package com.leikooo.regexpTest;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qxy
 * @Date: 2023/2/2 13
 * @Description:
 */
public class RegExp02 {
    /**
     * 匹配url 複雜
     */
    @Test
    public void test1() {
         // String content = "https://www.bilibili.com";
         String content = "https://manga.bilibili.com/blackboard/activity-kepYYWO1bW.html?from=bantou&spm_id_from=333.851.b_696e7465726e6174696f6e616c486561646572.40";

        /*
        1. url   ^((http|https)://)?
        2. 然后通过 ([\w-]+\.)+[\w-]+
        3. 第三部分
         */
        String regStr = "^((http|https)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-.#_=?&%/]*)?$"; // 注意：[. ? * / ]表示匹配就是. ? * / 本身
        String regStr1 = "^https?:\\/\\/(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()!@:%_\\+.~#?&\\/\\/=]*)$"; // 在网上找的
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
        // 整体匹配
        System.out.println("结果 = " + Pattern.matches(regStr, content));

    }
}
