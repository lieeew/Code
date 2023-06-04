package com.hspedu.Spring.JDBC;

import com.hspedu.Spring.bean.Monster;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * ClassName: MonsterDAO
 * Package: com.hspedu.Spring.JDBC
 *
 * @Author: leikooo
 * @Creat: 2023/6/3 - 22:10
 * @Description:
 */
@Repository // 将monsterDAO注入到容器
public class MonsterDAO {

    // 自动注入
    @Resource
    private JdbcTemplate jdbcTemplate;

    // 完成保存人物
    private void save(Monster monster) {
        String sql = "insert into monster value (?, ?, ?)";
        int affect = jdbcTemplate.update(sql, monster.getMonsterId(), monster.getName(), monster.getSkill());

    }

    public void monsterSaveDAO(Monster monster) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");

        MonsterDAO monsterDAO = ioc.getBean(MonsterDAO.class);

        monsterDAO.save(monster);
        System.out.println("保存 ok~");
    }
}
