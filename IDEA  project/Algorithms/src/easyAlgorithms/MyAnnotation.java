package easyAlgorithms;

import java.lang.annotation.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/3 - 11 - 03
 * @Description: easyAlgorithms
 */
@Repeatable(MyAnnotations.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotation {

    String value();
}
