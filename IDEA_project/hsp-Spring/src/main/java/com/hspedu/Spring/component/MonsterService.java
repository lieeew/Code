package com.hspedu.Spring.component;

import com.hspedu.Spring.Annotation.Autowired;
import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.Annotation.Scope;
import com.hspedu.Spring.processor.InitializingBean;

/**
 * ClassName: MonsterService
 * Package: com.hspedu.Spring.component
 *
 * @Author: leikooo
 * @Creat: 2023/5/29 - 12:04
 * @Description: 如果指定了value就按照指定的为准, 没有指定就按照类名首字母小写
 */
@Scope("prototype")
@Component("monsterService")
public class MonsterService implements InitializingBean {
    // 添加注解实现依赖注入
    // 使用名字装配
    @Autowired
    private MonsterDAO monsterDAO;

    public void hello() {
        System.out.println("monsterDAO😀 = " + monsterDAO);
        monsterDAO.hi();
    }

    /**
     * 老韩解读
     * 1. afterPropertiesSet 就是在bean的setter方法由Spring容器调用
     * 2. 不会主动调用, 这就是初始化方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MonsterService 的 afterPropertiesSet 初始化方法被调用");
    }
}
