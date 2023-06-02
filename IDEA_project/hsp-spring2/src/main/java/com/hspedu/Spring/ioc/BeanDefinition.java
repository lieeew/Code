package com.hspedu.Spring.ioc;

/**
 * ClassName: BeanDefinition
 * Package: com.hspedu.Spring.ioc
 *
 * @Author: leikooo
 * @Creat: 2023/6/1 - 12:22
 * @Description:
 */
public class BeanDefinition {
    private String scope;
    private Class clazz;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
