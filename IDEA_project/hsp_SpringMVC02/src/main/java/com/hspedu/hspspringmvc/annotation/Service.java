package com.hspedu.hspspringmvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author leikooo
 * @create 2023-06-15 12:04
 * @Package com.hspedu.hspspringmvc.annotation
 * @Description
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    String  value() default "";

}
