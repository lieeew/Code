package com.hspedu.hspSpringMVC.annotation;

import java.lang.annotation.*;

/**
 * @author leikooo
 * @create 2023-06-18 7:26
 * @Package com.hspedu.hspspringmvc.annotation
 * @Description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseBody {
}
