package com.hspedu.Spring.AOP.homework;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ClassName: UsbAspect2
 * Package: com.hspedu.Spring.AOP.homework
 *
 * @Author: leikooo
 * @Creat: 2023/5/27 - 20:06
 * @Description:
 */
@Order(value = 1)
@Aspect
@Component
public class UsbAspect2 {
    @Pointcut(value = "execution(public int com.hspedu.Spring.AOP.homework.Phone.work())")
    public void myPointCut() {

    }

    // 这里我们队UsbInterface 切入, 那么对实现类 phone 和 camera 对象都作用了
    @Before(value = "myPointCut()")
    public void showBeginLog(JoinPoint joinPoint) {
        System.out.println("UsbAspect2 切入点表达式 -- 使用前置通知-调用的方法名是 " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "myPointCut()", returning = "res")
    public void showSuccessLog(JoinPoint joinPoint, Object res) {
        System.out.println("UsbAspect2 正常执行后-输出的方法名" + joinPoint.getSignature().getName() + "-返回值是 " + res);
    }
    @AfterThrowing(value = "myPointCut()", throwing = "mes")
    public void showExceptionLog(JoinPoint joinPoint, Throwable mes) {
        System.out.println("UsbAspect2 出现异常 方法名：" + joinPoint.getSignature().getName() + "异常是  " + mes);

    }
    @After(value = "myPointCut()")
    public void showFinallyEndingLog(JoinPoint joinPoint) {
        System.out.println("UsbAspect2 方法最终执行完毕 finally{} -日志-方法名: " + joinPoint.getSignature().getName());
    }
    @Before(value = "execution(public void Car.run())")
    public void ok(JoinPoint joinPoint) {
        System.out.println("UsbAspect2 前置通知-调用的方法名是 " + joinPoint.getSignature().getName());
    }

}
