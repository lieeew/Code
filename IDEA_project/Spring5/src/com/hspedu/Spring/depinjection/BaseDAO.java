package com.hspedu.Spring.depinjection;

import org.springframework.stereotype.Repository;

/**
 * ClassName: BaseDAO
 * Package: com.hspedu.Spring.depinjection
 *
 * @Author: leikooo
 * @Creat: 2023/5/24 - 8:15
 * @Description:
 */
@Repository
public abstract class BaseDAO<T> {

    public abstract void save();
}
