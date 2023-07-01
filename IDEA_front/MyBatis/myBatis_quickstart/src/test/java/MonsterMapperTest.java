import com.hspedu.entity.Monster;
import com.hspedu.mapper.MonsterMapper;
import com.hspedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @author leikooo
 * @create 2023-07-01 11:35
 * @Package PACKAGE_NAME
 * @Description
 */
public class MonsterMapperTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    /**
     * 初始化方法
     * 1. @Before 表示执行你的目标测试方法之前，会先执行这个方法
     * 2. 这里测试有一些麻烦哦，加油！
     */
    @Before
    public void init() {
        // 得到 sqlSession
        sqlSession = MyBatisUtils.getSqlSession();
        // 获取到 MonsterMapper 对象
        // 底层使用的是动态代理机制，后面会写底层机制的
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
        // 输出 MonsterMapper 的类型
        System.out.println("monsterMapper = " + monsterMapper.getClass());
    }

    @Test
    public void test01() {
        for (int i = 0; i < 2; i++) {
            Monster monster = new Monster();
            monster.setAge(10 + i);
            monster.setName("小狗" + i);
            monster.setBirthday(new Date());
            monster.setEmail("liangzilixue@qq.com");
            monster.setSalary((double) (200 * i));
            monster.setGender(1);
            monsterMapper.addMonster(monster);
            System.out.println("添加成功！！");
            System.out.println("添加到表中的自id = ：" + monster.getId());
        }

        // 如果是增删改，需要提交事务
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void testDelete() {
        monsterMapper.deleteMonsterById(2);
        // 不提交事务不会生效
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void updateMonster() {
        Monster monster = new Monster();
        monster.setId(6);
        monster.setAge(666);
        monster.setBirthday(new Date());
        monster.setName("Jack Ma");
        monster.setEmail("MA@baidu.com");
        monster.setSalary(200.21);
        monster.setGender(1);

        monsterMapper.updateMonster(monster);

        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
