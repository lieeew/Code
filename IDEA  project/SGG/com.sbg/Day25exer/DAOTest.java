package Day25exer;

import org.junit.Test;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/14 - 11 - 14
 * @Description: Day25exer
 */
public class DAOTest {

    @Test
    public void test1() {
        CustomerDAO cus = new CustomerDAO();
        cus.addList(new Customer());

        StudentDAO stu = new StudentDAO();
        stu.addList(new Student());
    }
}
