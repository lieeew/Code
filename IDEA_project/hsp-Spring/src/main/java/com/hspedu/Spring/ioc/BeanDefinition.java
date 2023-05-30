package com.hspedu.Spring.ioc;

/**
 * ClassName: BeanDefinition
 * Package: com.hspedu.Spring.ioc
 *
 * @Author: leikooo
 * @Creat: 2023/5/29 - 17:05
 * @Description:  用于记录Bean的信息 class反射全路径 + 是否是单例
 */
public class BeanDefinition {
    private String scope;
    public Class clazz;

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
