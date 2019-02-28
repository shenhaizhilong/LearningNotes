package Annotation;

import java.lang.annotation.*;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/23 12:58
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
