package com.hspedu.Spring.depinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * ClassName: BaseService
 * Package: com.hspedu.Spring.depinjection
 *
 * @Author: leikooo
 * @Creat: 2023/5/24 - 8:15
 * @Description:
 */
@Service
public abstract class BaseService<T> {

    @Autowired
    private BaseDAO<T> baseDao;

    public void save() {
        baseDao.save();
    }

}
