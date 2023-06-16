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
}
