package Day25Exer2;

import org.junit.Test;

import java.util.Iterator;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/15 - 11 - 15
 * @Description: Day25Exer2
 */

public class DAOTest {
    /**
     * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方
     * 法来操作 User 对象，
     * 使用 Junit 单元测试类进行测试
     */
    @Test
    public void test1() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1001", new User("1001",12, "周杰伦"));
        userDAO.save("1002", new User("1002",13, "李华"));
        userDAO.save("1003", new User("1003", 14, "艾伦"));

        userDAO.delete("1001");
        userDAO.upDate("1002", new User("1002", 20, "邱鑫雨"));

        Iterator<User> iterator = userDAO.list().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
