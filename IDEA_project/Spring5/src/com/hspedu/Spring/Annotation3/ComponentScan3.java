package com.hspedu.Spring.Annotation3;

import org.springframework.stereotype.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: ComponentScan3
 * Package: com.hspedu.Spring.Annotation3
 *
 * @Author: leikooo
 * @Creat: 2023/5/23 - 14:40
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentScan3 {

    String value() default "";;
}
