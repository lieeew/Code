package com.hspedu.Spring.Annotation2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: ComponentScan2
 * Package: com.hspedu.Spring.Annotation2
 *
 * @Author: leikooo
 * @Creat: 2023/5/23 - 11:55
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentScan2 {
    String value() default "";
}
