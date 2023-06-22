package com.hspedu.hspSpringMVC.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: RequestMapping
 * Package: com.hspedu.hspspringmvc.annotation
 *
 * @Author: leikooo
 * @Creat: 2023/6/12 - 12:54
 * @Description:
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    String value() default "";
}
