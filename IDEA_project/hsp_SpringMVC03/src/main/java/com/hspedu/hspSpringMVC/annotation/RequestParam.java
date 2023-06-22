package com.hspedu.hspSpringMVC.annotation;

import java.lang.annotation.*;

/**
 * @author leikooo
 * @create 2023-06-16 21:45
 * @Package com.hspedu.hspspringmvc.annotation
 * @Description 表示在目标方法的参数上，表示对应的 http 请求的参数
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestParam {
    String  value() default "";

}
