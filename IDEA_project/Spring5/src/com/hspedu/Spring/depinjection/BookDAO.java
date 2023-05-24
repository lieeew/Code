package com.hspedu.Spring.depinjection;

import org.springframework.stereotype.Repository;

/**
 * ClassName: BookDAO
 * Package: com.hspedu.Spring.depinjection
 *
 * @Author: leikooo
 * @Creat: 2023/5/24 - 8:16
 * @Description:
 */
@Repository
public class BookDAO extends BaseDAO<Book>{

    @Override
    public void save() {
        System.out.println("BookDAO的save方法");
    }

}
