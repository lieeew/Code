package com.hspedu.hspSpringMVC.annotation;

import java.lang.annotation.*;

/**
 * @author leikooo
 * @create 2023-06-16 6:05
 * @Package com.hspedu.hspspringmvc.annotation
 * @Description 自动装配的类
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoWired {
    String value() default "";

}
