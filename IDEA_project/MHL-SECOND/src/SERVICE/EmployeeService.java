package SERVICE;

import DAO.DiningTableDAO;
import DAO.EmployeeDAO;
import DOMAIN.Employee;

import java.sql.PreparedStatement;

/**
 * @Author: qxy
 * @Date: 2023/1/25 12
 * @Description:
 */
public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    /**
     * 登录验证
     * @param empId 员工号
     * @param pwd 密码
     * @return true 为登录成功
     */
    public boolean logIn(String empId, String pwd) {
        Employee employee = employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);
        return employee != null;
    }
}
