package Annotation;

import java.lang.annotation.*;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/23 13:00
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor {
    public enum Color{BLUE,RED,GREEN}

    /**
     * color properity
     * @return
     */
    Color fruitColor() default Color.GREEN;
}
