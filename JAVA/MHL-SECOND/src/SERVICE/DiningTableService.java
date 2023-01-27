package SERVICE;

import DAO.DiningTableDAO;
import DOMAIN.DiningTable;
import VIEW.View;

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

    /**
     * 预订餐桌
     * @return 如果为true运行成功, 为false运行失败
     */
    public boolean orderDiningTable(String orderName, String orderTel, int id) {
        int update = diningTableDAO.update("update diningtable set state = '已预订', orderName = ?, orderTel = ? WHERE id = ?", orderName, orderTel, id);
        return update > 0;
    }
    /**
     * 检查餐桌编号是否存在
     * true代表存在 false代表不存在
     */
    public boolean isExist(int id) {
        DiningTable diningTable = diningTableDAO.querySingle("select * from diningtable where id = ? and state = '空'", DiningTable.class, id);
        return diningTable != null;
    }

    /**
     * 判断是否有桌号是否可以点餐
     * @return true代表存在     false代表不存在
     */
    public boolean isExitFree(int id) {
        DiningTable diningTable = diningTableDAO.querySingle("select * from diningtable where id = ? and state = '已预订'", DiningTable.class, id);
        return diningTable != null;
    }

    /**
     * 更新餐桌状态
     * @return true代表修改成功   false代表修改失败
     */
    public boolean changeStatus(int id, String status) {
        int update = diningTableDAO.update("update diningtable set state = ? where id = ?", status, id);
        return update > 0;
    }

    /**
     * 结账完成, 修改餐桌状态
     * @return true代表修改成功  false代表修改失败
     */
    public boolean changeStateToFree(int id) {
        int update = diningTableDAO.update("update diningtable set state = '空', orderName = '空', orderTel = '110' where id = ?", id);
        return update > 0;
    }

}
