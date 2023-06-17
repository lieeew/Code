package com.hspedu.Service.impl;

import com.hspedu.Service.HspService;
import com.hspedu.Service.MonsterService;
import com.hspedu.entity.Monster;
import com.hspedu.hspspringmvc.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leikooo
 * @create 2023-06-15 12:09
 * @Package com.hspedu.Service.impl
 * @Description
 */
@Service
public class MonsterServiceImpl implements MonsterService{

    @Override
    public List<Monster> listMonster() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster(100, "牛魔王", 400, "芭蕉扇"));
        monsters.add(new Monster(200, "老猫怪", 700, "抓老鼠"));
        return monsters;
    }

    @Override
    public List<Monster> listMonsterByName(String name) {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster(100, "牛魔王", 400, "芭蕉扇"));
        monsters.add(new Monster(200, "老猫怪", 700, "抓老鼠"));
        monsters.add(new Monster(300, "老魔王", 800, "抓老鬠"));
        monsters.add(new Monster(400, "白骨精", 900, "诱惑人"));

        // 创建返回集合， 返回添加到的查询到 monster 集合
        List<Monster> result = new ArrayList<>();
        for (Monster monster : monsters) {
            if (monster.getName().contains(name)) {
                result.add(monster);
            }
        }

        return result;
    }

    @Override
    public boolean login(String name) {
        // 实际上是去 DB 上验证
        return "leikooo".equals(name);
    }
}
