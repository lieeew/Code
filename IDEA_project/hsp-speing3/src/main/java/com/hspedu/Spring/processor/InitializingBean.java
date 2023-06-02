package com.hspedu.Spring.processor;

/**
 * ClassName: InitializingBean
 * Package: com.hspedu.Spring.processor
 *
 * @Author: leikooo
 * @Creat: 2023/5/30 - 17:47
 * @Description: 我们自己写的
 * 1. 我们根据原生的Spring, 定义了InitializingBean
 * 2. 该接口中有一个方法 void afterPropertiesSet() throws Exception;
 * 3. 这个方法会在setter方法之后执行, 就相当于原来配置的初始化方法
 * 4. 当一个Bean实现这个接口之后, 就实现了afterPropertiesSet, 那么这个方法方法就实现了初始化方法
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
