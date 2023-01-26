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
}
