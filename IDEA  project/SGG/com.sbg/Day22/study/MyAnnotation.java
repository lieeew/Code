package Day22.study;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/3 - 11 - 03
 * @Description: Day22.study
 */
@Target({ElementType.TYPE_USE, TYPE,FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";
}
