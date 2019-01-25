package javavm;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/24 10:00
 */
public class ConstClass {
    static {
        System.out.println("Const class init");

    }

    public static final String HELLLOWORLD = "hello world";
}
