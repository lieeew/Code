package com.leikooo.hspmybatis.sqlsession;

import com.leikooo.entity.Monster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author leikooo
 * @create 2023-07-13 6:37
 * @Package com.leikooo.hspmybatis.sqlsession
 * @Description
 */
public class HspExecutor implements Executor{
    private HspConfiguration configuration = new HspConfiguration();

    @Override
    public <T> T query(String sql, Object parameter) {
        // 得到连接
        Connection connection = configuration.build("hsp_mybatis.xml");
        // 简化流程
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            // 默认就传入一个参数
            preparedStatement.setInt(1, (Integer) parameter);
            resultSet = preparedStatement.executeQuery();

            Monster monster = new Monster();
            // 不要忘了还有这个 next() 方法
            if (resultSet.next()) {
                // 这里直接 new 了，底层肯定是使用反射
                monster.setId(resultSet.getInt("id"));
                monster.setAge(resultSet.getInt("age"));
                monster.setBirthday(resultSet.getDate("birthday"));
                monster.setEmail(resultSet.getString("email"));
                monster.setGender(resultSet.getInt("gender"));
                monster.setName(resultSet.getString("name"));
                monster.setSalary(resultSet.getDouble("salary"));

            }
            return (T) monster;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
