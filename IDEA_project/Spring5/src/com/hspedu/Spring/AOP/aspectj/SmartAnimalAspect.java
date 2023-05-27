package com.hspedu.Spring.AOP.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * ClassName: SmartAnimalAspect
 * Package: com.hspedu.Spring.AOP.aspectj
 *
 * @Author: leikooo
 * @Creat: 2023/5/25 - 16:44
 * @Description: 类似于我们自己之前写的 ProxyProvider
 */
@Component // 会注入到Spring容器
@Aspect // 表示是一个切面类 【底层切面编程的支撑(动态代理 + 反射 + 动态绑定 ~~)】
public class SmartAnimalAspect {

    // 希望将f1 切入到dog-getSum前执行

    /**
     * 1. @Before 表示前置通知 目标函数执行方法前执行
     * 2. value = "execution(public int com.hspedu.Spring.AOP.aspectj.Dog.getSum(int ,int))" 表示那个类的那个方法
     * 3. f1方法可以理解为一个切入方法， 方法名由程序猿指定 比如：showBeginLog
     * 4. JoinPoint joinPoint  在底层执行时会自动传入joinPoint对象
     */
    @Before(value = "execution(public int com.hspedu.Spring.AOP.aspectj.Dog.getSum(int ,int))")
    public static void showBeginLog(JoinPoint joinPoint) {
        // 拿到方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("方法执行前 - 日志 - 方法名- :" + signature.getName() + " -参数 " + Arrays.asList(joinPoint.getArgs()));
    }

    // 把f2切入到正常结束之后的通知
    @AfterReturning(value = "execution(public int com.hspedu.Spring.AOP.aspectj.Dog.getSum(int ,int))")
    public void showSuccessLog(JoinPoint joinPoint) {
        System.out.println("方法执行正常结束-日志-方法名: " + joinPoint.getSignature().getName());

    }

    @AfterThrowing(value = "execution(public int com.hspedu.Spring.AOP.aspectj.Dog.getSum(int ,int))")
    public void showExceptionLog(JoinPoint joinPoint) {
        System.out.println("方法执行异常-日志-方法名: " + joinPoint.getSignature().getName());

    }

    // 切入到方法执行之后 finally {}
    // 可以使用模糊配置
    @After(value = "execution(public int com.hspedu.Spring.AOP.aspectj.Dog.*(int ,int))")
    public void showFinallyEndingLog(JoinPoint joinPoint) {
        System.out.println("方法最终执行完毕 finally{} -日志-方法名: " + joinPoint.getSignature().getName());
    }

}