package com.hspedu.Spring.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ClassName: ComponentScan
 * Package: com.hspedu.Spring.Annotation
 *
 * @Author: leikooo
 * @Creat: 2023/5/22 - 11:17
 * @Description:
 * 1. @Target(ElementType.TYPE) 指定的是我们注解可以修饰的类型
 * 2. @Retention(RetentionPolicy.RUNTIME) 注解生效时间
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentScan {
    // 可以传入一个属性, 指定要扫描的包
    String value() default "";
}