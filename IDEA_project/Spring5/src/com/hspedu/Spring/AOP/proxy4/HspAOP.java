package com.hspedu.Spring.AOP.proxy4;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ClassName: HspAOP
 * Package: com.hspedu.Spring.AOP.proxy4
 *
 * @Author: leikooo
 * @Creat: 2023/5/25 - 11:05
 * @Description: 我么自己编写的aop类
 */
public class HspAOP {

    public static void before(Object proxy, Method method, Object[] args) {
        System.out.println("方法执行前 - 日志-方法名-" + method.getName() + "-参数 " + Arrays.asList(args));
    }

    public static void after(Method method, Object result) {
        System.out.println("方法执行正常结束 - 日志-方法名-" + method.getName() + "-结果 result= " + result);
    }
}
