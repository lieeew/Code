package com.hspedu.Service.impl;

import com.hspedu.Service.HspMonsterService;
import com.hspedu.entity.Monster;
import com.hspedu.hspspringmvc.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leikooo
 * @create 2023-06-18 19:31
 * @Package com.hspedu.Service.impl
 * @Description
 */
@Service("hspMonsterService")
public class HspMonsterServiceImpl implements HspMonsterService {

    @Override
    public List<Monster> listMonsters() {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster(100, "牛魔王", 200, "摸鱼"));
        monsters.add(new Monster(80, "狮子兽", 150, "爬山"));
        monsters.add(new Monster(120, "火龙", 250, "吃火锅"));
        monsters.add(new Monster(70, "飞鱼", 100, "游泳"));
        monsters.add(new Monster(90, "恶魔", 180, "打游戏"));

        return monsters;
    }
}
