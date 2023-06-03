package com.hspedu.Spring.Test;

import com.hspedu.Spring.bean.Monster;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: JDBCTemplateTest
 * Package: com.hspedu.Spring.Test
 *
 * @Author: leikooo
 * @Creat: 2023/6/3 - 6:52
 * @Description:
 */
public class JDBCTemplateTest {

    @Test
    public void test() throws SQLException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        DataSource dataSource = (DataSource) ioc.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
        connection.close();
    }

    // 添加到数据库
    @Test
    public void test2() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 方式一
//        String sql = "INSERT INTO monster VALUES (500, '紅孩兒', '枪法')";
//        jdbcTemplate.execute(sql);
//        System.out.println("添加成功!!!");

        // 方式二
        String sql = "INSERT INTO monster VALUES (?, ?, ?)";
        int affected = jdbcTemplate.update(sql, 600, "牛魔王", "芭蕉扇");
        System.out.println("受影响的行数 = " + affected);

    }

    // 修改数据库
    @Test
    public void test3() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 小细节 : 不会判断是不是一样的值, 一样也会执行sql语句
        String sql = "update monster set skill = ? where id = ?";
        int affected = jdbcTemplate.update(sql, "美女记", 200);
        System.out.println("受影响的行数 = " + affected);

    }


    // 查询
    @Test
    public void test4() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        String sql = "select count(*) from monster";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("integer = " + integer);

    }

    /**
     * 批量插入 俩个monster对象
     */
    @Test
    public void test5() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 1. 批量插入 猜测update => 根据参数修改名称是 batchUpdate
        // 2. 根据参数提供数据
        String sql = "insert into monster values (?, ?, ?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{700, "老鼠精", "偷吃粮食"});
        list.add(new Object[]{800, "老猫精", "抓老鼠"});
        // 3. 调试
        // 说明:
        // 返回结果是一个数组, 每一个元素对应的上面的sql语句影响的行数
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        // 4. 输出
        for (int anInt : ints) {
            System.out.println("anInt: " + anInt);
        }

        System.out.println("add ok ~");
    }

    // 查询 id=100 的 monster 并封装到 Monster 实体对象
    @Test
    public void test6() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 确定API
        // <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
        String sql = "select id AS `monsterId`, name, skill from monster where id = ?";

        //这里有一个细节就是名称需要一样, 即查询的表字需要和查询的字段保持一致
        RowMapper<Monster> rowMapper = new RowMapper<Monster>() {
            @Override
            public Monster mapRow(ResultSet rs, int rowNum) throws SQLException {
                Monster monster = new Monster();
                monster.setSkill(rs.getString("skill"));
                monster.setName(rs.getString("name"));
                monster.setMonsterId(rs.getInt("monsterId"));
                return monster;
            }
        };

        // 可以使用lambda表达式简化
        Monster monster = jdbcTemplate.queryForObject(sql, rowMapper, 100);

        System.out.println("monster = " + monster);
    }

    // 查询 id=100 的 monster 并封装到 Monster 实体对象
    @Test
    public void test7() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 确定API
        // <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
        String sql = "select id AS `monsterId`, name, skill from monster where id = ?";
        // 使用子类实现对象的封装
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        Monster monster = jdbcTemplate.queryForObject(sql, rowMapper, 100);
        System.out.println("monster = " + monster);

    }

    // 查询 id>=200 的 monster 并封装到 Monster 实体对象
    @Test
    public void test8() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 确定API
        // <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
        String sql = "select id AS `monsterId`, name, skill from monster where id > ?";

        List<Monster> monsterList = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            Monster monsters = new Monster(rs.getInt("monsterId"), rs.getString("name"), rs.getString("skill"));
            return monsters;
        }, 100);

        for (Monster monster : monsterList) {
            System.out.println("monster = " + monster);
        }

    }

    // 查询 id>=200 的 monster 并封装到 Monster 实体对象
    @Test
    public void test9() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 确定API
        String sql = "select id AS `monsterId`, name, skill from monster where id > ?";
        RowMapper<Monster> rowMapper = new BeanPropertyRowMapper<>(Monster.class);
        List<Monster> query = jdbcTemplate.query(sql, rowMapper, 100);
        for (Monster monster : query) {
            System.out.println("monster = " + monster);
        }

    }

    // 查询返回结果只有一行一列的值，比如查询 id=100 的怪物名
    @Test
    public void test10() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 确定API
        // <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
        String sql = "select  name from monster where id = ?";
        String name = jdbcTemplate.queryForObject(sql,
                (ResultSet rs, int rowNum) -> rs.getString("name"), 200);
        System.out.println("name = " + name);

    }

    @Test
    public void test11() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

        // 确定API
        // <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
        String sql = "select name from monster where id = ?";

        String name = jdbcTemplate.queryForObject(sql, String.class, 200);
        System.out.println("name = " + name);
    }


    // 使用具名参数
    // 使用 Map 传入具名参数完成操作，比如添加 螃蟹精.:name 就是具名参数形式需要使用 NamedParameterJdbcTemplate 类
    @Test
    public void test12() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);

        // 具名参数
        // :id, :name, :skill 不需要知道表的结构
        String sql = "insert into monster values (:id, :name, :skill)";
        Map<String, Object> map = new HashMap<>();
        map.put("id", 900);
        map.put("name", "蚂蚁精");
        map.put("skill", "喜欢打洞");
        int affected = namedParameterJdbcTemplate.update(sql, map);
        System.out.println("affected = " + affected);
    }

    // 使用 sqlparametersoruce 来封装具名参数,还是添加一个Monster 狐狸精
    @Test
    public void test13() {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);

        // 	public Map<String, Object> queryForMap(String sql, SqlParameterSource paramSource)
        // 确定API
        // 准备参数
        String sql = "insert into monster values (:monsterId, :name, :skill)";
        Monster monster = new Monster(1000, "大象精", "搬运木头");
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(monster);
        int update = namedParameterJdbcTemplate.update(sql, sqlParameterSource);

        System.out.println("update = " + update);


    }
}
