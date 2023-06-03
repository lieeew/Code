package com.hspedu.Spring.Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Objects
 * Package: com.hspedu.Spring.Test
 *
 * @Author: leikooo
 * @Creat: 2023/6/3 - 11:49
 * @Description:
 */
public class ObjectsTest {

    @Test
    public void test() {
        List<Object> list = new ArrayList<Object>();
        list.add(new Object[]{700, "老鼠精", "偷吃粮食"});
        list.add(new Object[]{800, "老猫精", "抓老鼠"});

        // 获取第一个元素的数组
        Object[] firstArray = (Object[]) list.get(0);
        int firstValue = (int) firstArray[0];
        String firstString1 = (String) firstArray[1];
        String firstString2 = (String) firstArray[2];

        // 获取第二个元素的数组
        Object[] secondArray = (Object[]) list.get(1);
        int secondValue = (int) secondArray[0];
        String secondString1 = (String) secondArray[1];
        String secondString2 = (String) secondArray[2];

        System.out.println("第一个元素的值：" + firstValue);
        System.out.println("第一个元素的字符串1：" + firstString1);
        System.out.println("第一个元素的字符串2：" + firstString2);
        System.out.println("第二个元素的值：" + secondValue);
        System.out.println("第二个元素的字符串1：" + secondString1);
        System.out.println("第二个元素的字符串2：" + secondString2);

    }
}
