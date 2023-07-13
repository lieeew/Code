
import com.github.javafaker.Faker;
import com.leikooo.entity.Monk;
import com.leikooo.mapper.MonkMapper;
import com.leikooo.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;


/**
 * @author leikooo
 * @create 2023-07-11 21:44
 * @Package PACKAGE_NAME
 * @Description
 */
public class MonkTest {
    private SqlSession sqlSession;
    private MonkMapper monkMapper;

    @Before
    public void init() {
        // 得到 sqlSession
        sqlSession = MyBatisUtils.getSqlSession();
        monkMapper = sqlSession.getMapper(MonkMapper.class);
    }

    @Test
    public void testAddMonk() {
        Faker faker = new Faker();

        String nickname = faker.name().firstName();
        String skill = faker.job().position();
        int grade = faker.number().numberBetween(1, 10);
        double salary = faker.number().randomDouble(2, 1000, 10000);
        // Generate a random date between 1970-01-01 and current date
        long startDate = 0L;
        long endDate = System.currentTimeMillis();
        Date randomDate = faker.date().between(new Date(startDate), new Date(endDate));
        java.sql.Date birthday = new java.sql.Date(randomDate.getTime());

        System.out.println("Nickname: " + nickname);
        System.out.println("Skill: " + skill);
        System.out.println("Grade: " + grade);
        System.out.println("Salary: " + salary);
        System.out.println("Birthday: " + birthday);
    }

    @Test
    public void testInsertMonk() {
        Monk monk = new Monk(4, "leikooo", "song", 9, 2000.0, new Timestamp(1232L), new Date(12333L));
        monkMapper.addMonk(monk);

        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    /**
     * 更新 monk
     */
    @Test
    public void testSetMonk() {
        Monk monk = new Monk(1, "leikooo", "piano", 9, 2000.0, new Timestamp(1111432434343L), new Date(12333L));
        monkMapper.updateMonk(monk);

        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    /**
     * 测试 delete 语句
     */
    @Test
    public void testDeleteMonk() {
        int i = monkMapper.deleteMonk(2);

        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void testGetMonk() {
        Monk monk = monkMapper.getMonk(1);
        System.out.println("monk = " + monk);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

}
