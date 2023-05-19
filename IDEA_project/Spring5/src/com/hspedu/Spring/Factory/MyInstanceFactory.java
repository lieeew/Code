package com.hspedu.Spring.Factory;

import com.hspedu.Spring.bean.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MyInstanceFactory
 * Package: com.hspedu.Spring.Factory
 *
 * @Author: leikooo
 * @Creat: 2023/5/19 - 6:25
 * @Description:
 */
public class MyInstanceFactory {
    private Map<String, Monster> monster_map;

    // 非静态代码块
    {
        monster_map = new HashMap<String, Monster>();
        monster_map.put("monster_01", new Monster(100, "猴子精", "吃人"));
        monster_map.put("monster_02", new Monster(200, "九头金雕", "如来神掌"));
    }

    public Monster getMonster(String key) {
        return monster_map.get(key);
    }

}
