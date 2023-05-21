package com.hspedu.Spring.Factory;

import com.hspedu.Spring.bean.Monster;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MyBeanFactory02
 * Package: com.hspedu.Spring.Factory
 *
 * @Author: leikooo
 * @Creat: 2023/5/21 - 14:43
 * @Description:
 */
public class MyBeanFactory02 implements FactoryBean<Monster> {
    private String key;
    private Map<String, Monster> monster_map;

    // 非静态代码块
    {
        monster_map = new HashMap<String, Monster>();
        monster_map.put("monster_01", new Monster(100, "猴子精", "吃人~~~"));
        monster_map.put("monster_02", new Monster(200, "九头金雕", "如来神掌"));
    }
    @Override
    public Monster getObject() throws Exception {
        return monster_map.get(key);
    }

    @Override
    public Class<?> getObjectType() {
        return Monster.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
