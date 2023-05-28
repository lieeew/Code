package com.hspedu.Spring.AOP.homework02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * ClassName: CalAspect
 * Package: com.hspedu.Spring.AOP.homework02
 *
 * @Author: leikooo
 * @Creat: 2023/5/28 - 10:28
 * @Description:
 */
//@Component
//@Aspect
public class CalAspect {
    public void cutPoint() {

    }

    public void beforeLog(JoinPoint joinPoint) {
        System.out.println("在执行方法" + joinPoint.getSignature().getName() + " 打印前开始的时间是--" + System.currentTimeMillis());
    }

    public void afterLog(JoinPoint joinPoint, Object result) {
        System.out.println("在执行方法" + joinPoint.getSignature().getName() + " 打印后开始的时间是--" + System.currentTimeMillis() + " 方法的结果是" + result);
    }

    public void printLogAfterException(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("方法 " + joinPoint.getSignature().getName() + " 报错了信息是" + throwable);
    }


    public void finallyLog(JoinPoint joinPoint) {
        System.out.println("方法执行" + joinPoint.getSignature().getName() + "结束之后~~");

    }
}
