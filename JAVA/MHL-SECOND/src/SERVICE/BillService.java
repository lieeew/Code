package SERVICE;

import DAO.BillDAO;
import DOMAIN.Menu;

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
     *
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

}
