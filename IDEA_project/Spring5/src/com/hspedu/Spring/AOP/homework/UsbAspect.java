package com.hspedu.Spring.AOP.homework;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * ClassName: UsbAspect
 * Package: com.hspedu.Spring.AOP.homework
 *
 * @Author: leikooo
 * @Creat: 2023/5/26 - 14:54
 * @Description:
 */
@Component
@Aspect
public class UsbAspect {

    // 这里我们队UsbInterface 切入, 那么对实现类 phone 和 camera 对象都作用了
    @Before(value = "execution(public int com.hspedu.Spring.AOP.homework.UsbInterface.work())")
    public void showBeginLog(JoinPoint joinPoint) {
        System.out.println("前置通知-调用的方法名是 " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(public int com.hspedu.Spring.AOP.homework.Phone.work())")
    public void showSuccessLog(JoinPoint joinPoint) {
        System.out.println("正常执行后-输出的方法名" + joinPoint.getSignature().getName());
    }
    @AfterThrowing(value = "execution(public int com.hspedu.Spring.AOP.homework.Phone.work())")
    public void showExceptionLog(JoinPoint joinPoint) {
        System.out.println("出现异常 方法名：" + joinPoint.getSignature().getName());

    }
    @After(value = "execution(public int com.hspedu.Spring.AOP.homework.Phone.work())")
    public void showFinallyEndingLog(JoinPoint joinPoint) {
        System.out.println("方法最终执行完毕 finally{} -日志-方法名: " + joinPoint.getSignature().getName());
    }

    @Before(value = "execution(public void Car.run())")
    public void ok(JoinPoint joinPoint) {
        System.out.println("前置通知-调用的方法名是 " + joinPoint.getSignature().getName());
    }
}
