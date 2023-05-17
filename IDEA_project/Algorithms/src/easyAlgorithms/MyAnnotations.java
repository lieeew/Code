package easyAlgorithms;

import java.lang.annotation.*;

/**
 * @Auther: QiuXinYu
 * @Date: 2022/11/3 - 11 - 03
 * @Description: easyAlgorithms
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface MyAnnotations {

    MyAnnotation[] value(); // 需要MyAnnotation类型的数组
}
