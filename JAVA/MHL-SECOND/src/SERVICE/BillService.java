package SERVICE;

import DAO.BillDAO;
import DOMAIN.Bill;
import DOMAIN.Menu;

import java.util.List;
import java.util.UUID;

/**
 * @Author: qxy
 * @Date: 2023/1/25 12
 * @Description:
 */
public class BillService {
    private BillDAO billDAO = new BillDAO();
    private DiningTableService diningTableService = new DiningTableService();
    private MenuService menuService = new MenuService();
    /**
     * 点餐
     * @return true成功   false失败
     */
    public boolean orderMenu(int diningTableId, int menuId, int nums, String status) {
        String id = UUID.randomUUID().toString();

        if (!diningTableService.isExitFree(diningTableId)) {
            System.out.println("=========餐桌不存在=========");
            return false;
        }

        if (!menuService.isExist(menuId)) {
            System.out.println("=========菜品不存在=========");
            return false;
        }

        int update = billDAO.update("insert into bill values (null, ?, ?, ?, ?, ?, now(), ?)", id, menuId, nums, menuService.getMenu(menuId).getPrice() * nums, diningTableId, status);

        if (update < 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 返回菜单
     */
    public List<Bill> billList () {
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    /**
     * 判断是否有需要结账的餐桌
     * @return ture代表修改成功   false代表修改失败
     */
    public boolean haveToPay(int diningTableId) {
        Bill bill = billDAO.querySingle("select * from bill where diningTableId = ? and state = '未结账' LIMIT 0, 1", Bill.class, diningTableId);
        return bill != null;
    }

    /**
     * 结账
     * @return true代表成功  false代表失败
     */
    public boolean payBill(int diningTableId, String state) {
        // 修改bill表
        int update = billDAO.update("update bill set state = ? where diningTableId = ?", state, diningTableId);
        if (update <= 0) {
            return false;
        }
        // 修改diningTable表
        if (!diningTableService.changeStateToFree(diningTableId)) {
            return false;
        }
        return true;
    }

}
