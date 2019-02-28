package Annotation;

import java.lang.annotation.*;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/23 13:03
 */

@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitProvider {

     int id() default 0;
     String name() default "";
     String address() default "";
}
