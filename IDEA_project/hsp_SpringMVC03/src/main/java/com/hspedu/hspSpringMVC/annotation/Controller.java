package com.hspedu.hspSpringMVC.annotation;

import java.lang.annotation.*;

/**
 * ClassName: Controller
 * Package: com.hspedu.hspspringmvc.annotation
 *
 * @Author: leikooo
 * @Creat: 2023/6/12 - 12:50
 * @Description: 注解标识一个控制器注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) // 可以通过反射获取到
@Documented
public @interface Controller {
    String value() default "";

}
