package com.hspedu.hspspringmvc.annotation;

import java.lang.annotation.*;

/**
 * @author leikooo
 * @create 2023-06-19 17:01
 * @Package com.hspedu.hspspringmvc.annotation
 * @Description 自动注入
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Resource {
    String value() default "";
}
