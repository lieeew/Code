package com.hspedu.Spring.component;

import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.Annotation.Scope;

/**
 * ClassName: MonsterDAO
 * Package: com.hspedu.Spring.component
 *
 * @Author: leikooo
 * @Creat: 2023/5/29 - 12:06
 * @Description:
 */
@Scope
@Component
public class MonsterDAO {

    public void hi() {
        System.out.println("MonsterDAO-hi()~");
    }
}
