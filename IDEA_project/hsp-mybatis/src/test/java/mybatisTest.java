import com.leikooo.entity.Monster;
import com.leikooo.hspmybatis.config.MapperBean;
import com.leikooo.hspmybatis.sqlsession.Executor;
import com.leikooo.hspmybatis.sqlsession.HspConfiguration;
import com.leikooo.hspmybatis.sqlsession.HspExecutor;
import com.leikooo.hspmybatis.sqlsession.HspSqlSession;
import com.leikooo.mapper.MonsterMapper;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author leikooo
 * @create 2023-07-12 19:52
 * @Package PACKAGE_NAME
 * @Description
 */
public class mybatisTest {
    @Test
    public void testConnection() throws Exception {
        HspConfiguration hspConfiguration = new HspConfiguration();
        Connection build = hspConfiguration.build("hsp_mybatis.xml");
//        System.out.println("build = " + build);
        PreparedStatement preparedStatement = build.prepareStatement("select * from hsp_mybatis.`monster` where id = 1");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("resultSet = " + resultSet);
    }

    @Test
    public void testQuery() throws Exception {
        Executor hspExecutor = new HspExecutor();
        Object query = hspExecutor.query("select * from `monster` where id = ?", 1);
        System.out.println("query = " + query);

    }

    @Test
    public void testSelectOne() {
        HspSqlSession hspSqlSession = new HspSqlSession();
        Object instance = hspSqlSession.selectOne("select * from `monster` where id = ?", 1);
        System.out.println("instance = " + instance);
    }

    @Test
    public void testReadMapper() {
        HspConfiguration hspConfiguration = new HspConfiguration();
        MapperBean mapperBean = hspConfiguration.readMapper("MonsterMapper.xml");
        System.out.println("mapperBean = " + mapperBean);
    }

    @Test
    public void testGetMapper() {
        HspSqlSession hspSqlSession = new HspSqlSession();
        MonsterMapper mapper = hspSqlSession.getMapper(MonsterMapper.class);
        System.out.println(mapper.getClass());
        Monster monsterById = mapper.getMonsterById(1);
        System.out.println("monsterById = " + monsterById);

    }
}
