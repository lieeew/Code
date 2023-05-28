package com.hspedu.Spring.AOP.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.awt.image.Kernel;
import java.util.Arrays;

/**
 * ClassName: SmartAnimalAspect2
 * Package: com.hspedu.Spring.AOP.aspectj
 *
 * @Author: leikooo
 * @Creat: 2023/5/27 - 16:10
 * @Description: 演示环绕通知
 */
@Component
@Aspect
public class SmartAnimalAspect2 {

    // 切入表达式, 这个就是可以代替前面4个注解
    @Around(value = "execution(public int Dog.getSum(int ,int))")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("AOP环绕通知 --" + name + "方法开始执行--形参有: " + Arrays.asList(args));
            result = joinPoint.proceed();
            System.out.println("AOP环绕通知 " + name + " 方法执行结束 -- 结果是 " + result);
        } catch (Throwable e) {
            System.out.println("AOP环绕通知, 出现异常: " + e);
        } finally {
            System.out.println("AOP最终通知 ~~");
        }
        return result;
    }

}
