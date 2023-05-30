package com.hspedu.Spring.component;

import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.Annotation.Scope;
import com.hspedu.Spring.processor.InitializingBean;

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
public class MonsterDAO implements InitializingBean {

    public void hi() {
        System.out.println("MonsterDAO-hi()~");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MonsterDAO 初始化方法被调~");
    }
}
