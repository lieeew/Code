package com.hspedu.Spring.Test;

import com.hspedu.Spring.Annotation.HspSpringApplicationContext;
import com.hspedu.Spring.Annotation.HspSpringConfigure;

/**
 * ClassName: HspSpringApplicationContextTest
 * Package: com.hspedu.Spring.Test
 *
 * @Author: leikooo
 * @Creat: 2023/5/22 - 11:44
 * @Description:
 */
public class HspSpringApplicationContextTest {
    public static void main(String[] args) {
        HspSpringApplicationContext hspSpringApplicationContext = new HspSpringApplicationContext(HspSpringConfigure.class);

    }
}
