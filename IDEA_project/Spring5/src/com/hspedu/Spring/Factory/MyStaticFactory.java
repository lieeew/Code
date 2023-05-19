package com.hspedu.Spring.Factory;

import com.hspedu.Spring.bean.Monster;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MyStaticFactory
 * Package: com.hspedu.Spring.Factory
 *
 * @Author: leikooo
 * @Creat: 2023/5/19 - 6:09
 * @Description: 静态工厂类
 */
public class MyStaticFactory {
    private static Map<String, Monster> monsterMap;

    // 使用静态代码块
    static {
        monsterMap = new HashMap<String, Monster>();
        monsterMap.put("1", new Monster(1, "牛魔王", "芭蕉扇"));
        monsterMap.put("2", new Monster(2, "狐狸精", "美人计"));
    }

    /**
     * 返回对应的 monster
     */
    public static Monster getMonster(String key) {
        return monsterMap.get(key);
    }

}
