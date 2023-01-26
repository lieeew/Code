package SERVICE;

import DAO.DiningTableDAO;
import DOMAIN.DiningTable;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/1/25 12
 * @Description:
 */
public class DiningTableService {
    private DiningTableDAO diningTableDAO = new DiningTableDAO();


    /**
     * 返回餐桌信息
     * @return list 集合
     */
    public List<DiningTable> list() {
        return diningTableDAO.queryMulti("select id, state  from diningtable", DiningTable.class);
    }

}
