package com.hspedu.Spring.component;

import com.hspedu.Spring.Annotation.Autowired;
import com.hspedu.Spring.Annotation.Component;
import com.hspedu.Spring.Annotation.Scope;

/**
 * ClassName: MonsterService
 * Package: com.hspedu.Spring.component
 *
 * @Author: leikooo
 * @Creat: 2023/5/29 - 12:04
 * @Description: 如果指定了value就按照指定的为准, 没有指定就按照类名首字母小写
 */
@Component("monsterService")
public class MonsterService  {
    // 添加注解实现依赖注入
    // 使用名字装配
    @Autowired
    private MonsterDAO monsterDAO;

    public void hello() {
        System.out.println("monsterDAO😀 = " + monsterDAO);
        monsterDAO.hi();
    }

}
