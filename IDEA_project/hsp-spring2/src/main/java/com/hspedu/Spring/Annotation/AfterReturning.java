package com.hspedu.Spring.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: After
 * Package: com.hspedu.Spring.Annotation
 *
 * @Author: leikooo
 * @Creat: 2023/5/31 - 18:12
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AfterReturning {
    String value() default "";

    String pointcut() default "";

    String returning() default "";

    String argNames() default "";
}
