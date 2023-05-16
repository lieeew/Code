package Day25exer;

import java.util.List;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/14 - 11 - 14
 * @Description: Day25exer
 */

// Date access obect
public class DAO<T> { // 表共性的操作的DAO

    // 添加一条记录
    public boolean addList(T t) {
        return true;
    }

    // 删除一条记录
    public boolean deleteList(int index) {
        return false;
    }

    // 查询一条记录
    public T getList(int index) {
        return null;
    }

    // 查询多条数据
    public List<T> getAllList() {
        return null;
    }

    public <E> E getMax() {
        return null;
    }

}
