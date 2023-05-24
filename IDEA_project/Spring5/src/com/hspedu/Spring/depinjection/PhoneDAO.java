package com.hspedu.Spring.depinjection;

import org.springframework.stereotype.Repository;

/**
 * ClassName: PhoneDAO
 * Package: com.hspedu.Spring.depinjection
 *
 * @Author: leikooo
 * @Creat: 2023/5/24 - 8:19
 * @Description:
 */
@Repository
public class PhoneDAO extends BaseDAO<Phone> {
    @Override
    public void save() {
        System.out.println("phoneDAO 的save()方法");
    }
}
