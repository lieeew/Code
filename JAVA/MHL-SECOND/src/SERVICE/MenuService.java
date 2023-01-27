package SERVICE;

import DAO.MenuDAO;
import DOMAIN.Menu;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/1/25 12
 * @Description:
 */
public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    /**
     * 显示 menuList
     */
    public List<Menu> menuList () {
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    /**
     * 判断菜品单号是否存在
     * @return true为存在  false为不存在
     */
    public boolean isExist(int id) {
        Menu menu = menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
        return menu != null;
    }

    /**
     * 根据id返回菜品对象
     */
    public Menu getMenu(int id) {
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
    }
}
