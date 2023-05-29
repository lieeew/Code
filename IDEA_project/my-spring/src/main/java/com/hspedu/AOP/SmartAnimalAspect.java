package com.hspedu.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * ClassName: SmartAnimalAspect
 * Package: com.hspedu.AOP
 *
 * @Author: leikooo
 * @Creat: 2023/5/29 - 5:51
 * @Description:
 */
@Component
@Aspect
public class SmartAnimalAspect {

    // 给SmartDog配置, 前置、后置、异常、最终
    @Before("execution(public float SmartAnimal.*(float , float))")
    public void showBeginLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("方法执行前 - 日志 - 方法名- :" + signature.getName() + " -参数 " + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "execution(public float SmartAnimal.*(float , float))", returning = "res")
    public void showSuccessLog(JoinPoint joinPoint, Object res) {
        System.out.println("返回的结果是: " + res);
        System.out.println("方法执行正常结束-日志-方法名: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(public float SmartAnimal.*(float , float))", throwing = "throwable")
    public void showExceptionLog(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("方法执行异常-日志-方法名: " + joinPoint.getSignature().getName());
        // 异常是mes = java.lang.ArithmeticException: / by zero
        System.out.println("异常是mes = " + throwable);
    }

    @After(value = "execution(public float SmartAnimal.*(float , float))")
    public void showFinallyEndingLog(JoinPoint joinPoint) {
        System.out.println("方法最终执行完毕 finally{} -日志-方法名: " + joinPoint.getSignature().getName());
    }

}
