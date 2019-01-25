package javavm;

import java.lang.reflect.Field;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/16 18:21
 */
public class ReflectStringDemo {
    public static void main(String[] args) throws IllegalAccessException {
        String str = "Hello, world!";
        Field stringValueField = null;
        try
        {
            stringValueField = String.class.getDeclaredField("value");

        }catch (NoSuchFieldException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        if(stringValueField != null)
        {
            stringValueField.setAccessible(true);
            char[] value = (char[])stringValueField.get(str);
            value[5] = '_';
            value[6] = '+';
            System.out.println(str);

        }

    }
}
