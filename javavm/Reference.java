package javavm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/20 18:25
 */
public class Reference {
    public static void main(String[] args) {
        Object object = new Object();
        SoftReference<Object> objectSoftReference = new SoftReference<>(object);
        object = null;


        Object object2 = new Object();
        WeakReference<Object> objectWeakReference = new WeakReference<>(object2);
        object2 = null;



    }
}
