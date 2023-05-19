package com.hspedu.Spring.hspapplicationcontext;

import com.hspedu.Spring.bean.Monster;

/**
 * ClassName: HspApplicationContextTest
 * Package: com.hspedu.Spring.hspapplicationcontext
 *
 * @Author: leikooo
 * @Creat: 2023/5/17 - 15:58
 * @Description:
 */
public class HspApplicationContextTest {
    public static void main(String[] args) throws ClassNotFoundException {
        HspApplicationContext hspApplicationContext = new HspApplicationContext("beans.xml");

        Monster monster01 = (Monster) hspApplicationContext.getBean("monster01");
        System.out.println("monster01 = " + monster01);
    }

}
