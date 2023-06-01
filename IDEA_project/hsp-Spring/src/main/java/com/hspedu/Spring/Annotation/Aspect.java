package com.hspedu.Spring.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Aspect
 * Package: com.hspedu.Spring.Annotation
 *
 * @Author: leikooo
 * @Creat: 2023/5/31 - 18:11
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Aspect {
    String value() default "";
}
