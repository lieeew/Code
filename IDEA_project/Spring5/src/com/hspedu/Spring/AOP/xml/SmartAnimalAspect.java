package com.hspedu.Spring.AOP.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import java.util.Arrays;

/**
 * ClassName: SmartAnimalAspect
 * Package: com.hspedu.Spring.AOP.xml
 *
 * @Author: leikooo
 * @Creat: 2023/5/28 - 8:21
 * @Description:
 */
public class SmartAnimalAspect {

    public static void showBeginLog(JoinPoint joinPoint) {
        // 拿到方法签名
        Signature signature = joinPoint.getSignature();
        System.out.println("方法执行前 - 日志 - 方法名- :" + signature.getName() + " -参数 " + Arrays.asList(joinPoint.getArgs()));
    }

    public void showSuccessLog(JoinPoint joinPoint, Object res) {
        // 目标方法的返回结果
        System.out.println("返回的结果是: " + res);
        System.out.println("方法执行正常结束-日志-方法名: " + joinPoint.getSignature().getName());

    }

    public void showExceptionLog(JoinPoint joinPoint, Throwable mes) {
        System.out.println("方法执行异常-日志-方法名: " + joinPoint.getSignature().getName());
        // 异常是mes = java.lang.ArithmeticException: / by zero
        System.out.println("异常是mes = " + mes);
    }

    // 切入到方法执行之后 finally {}
    // 可以使用模糊配置
    public void showFinallyEndingLog(JoinPoint joinPoint) {
        System.out.println("方法最终执行完毕 finally{} -日志-方法名: " + joinPoint.getSignature().getName());
    }

}
