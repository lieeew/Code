package com.hspedu.Spring.component;

import com.hspedu.Spring.Annotation.AfterReturning;
import com.hspedu.Spring.Annotation.Aspect;
import com.hspedu.Spring.Annotation.Before;
import com.hspedu.Spring.Annotation.Component;

/**
 * ClassName: SmartAnimalAspect
 * Package: com.hspedu.Spring.component
 *
 * @Author: leikooo
 * @Creat: 2023/5/31 - 17:49
 * @Description:
 */
//@Component
//@Aspect
public class SmartAnimalAspect {
    @Before(value = "execution(public float com.hspedu.Spring.component.SmartAnimal.getSum(float , float))")
    public static void beforeLog() {
        System.out.println("前置通知~😀");
    }

    @AfterReturning(value = "execution(public float com.hspedu.Spring.component.SmartAnimal.getSum(float , float))")
    public static void afterLog() {
        System.out.println("后置通知~👌");
    }

}

