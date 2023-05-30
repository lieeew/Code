package com.hspedu.Spring.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Component
 * Package: com.hspedu.Spring.Annotation
 *
 * @Author: leikooo
 * @Creat: 2023/5/29 - 12:01
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    // 通过value属性自动bean的id
    String value() default "";
}
