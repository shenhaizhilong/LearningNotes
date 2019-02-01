package javavm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/1 10:55
 *
 * vm arguments:  -Xmx10M -XX:MaxDirectMemorySize=10M
 */
public class DirectMem {

    public static void main(String[] args) throws IllegalAccessException,NoSuchFieldException {
        // 利用反射得到 unSafe theUnsafe 字段
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        // 允许访问这个字段
        unsafeField.setAccessible(true);
        // 得到 theUnsafe instance
        Unsafe unsafeInstance = (Unsafe)unsafeField.get(null);
        while (true)
        {
            unsafeInstance.allocateMemory(1024*1024);
        }

    }
}
