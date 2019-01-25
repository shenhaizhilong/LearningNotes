package DesignPattern.Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/24 20:32
 *
 * 当 StaticInnerClassSingleton 类加载时，静态内部类 SingletonHandler 没有被加载进内存。只有当调用 getSingleton() 方法从而触发
 * SingletonHandler.singleton 时 SingletonHandler 才会被加载，此时初始化 singleton 实例，并且 JVM 能确保 singleton 只被实例化一次。
 *
 * 这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。
 * 静态内部类实现单例模式
 * 不足： 反序列化时仍可以得到多例 所以需要readResolve() method
 */
public final class StaticInnerClassSingleton implements Serializable {

    private static class SingletonHandler
    {
        private static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton()
    {

    }

    public static StaticInnerClassSingleton getSingleton()
    {
        return SingletonHandler.singleton;
    }


    protected Object readResolve() throws ObjectStreamException
    {
        return SingletonHandler.singleton;
    }


    public static void main(String[] args) {
        StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getSingleton();
        StaticInnerClassSingleton singleton1 = StaticInnerClassSingleton.getSingleton();
        System.out.println(singleton.hashCode() == singleton1.hashCode());

        Runnable task = new Runnable() {
            @Override
            public void run() {
                StaticInnerClassSingleton singleton2 = StaticInnerClassSingleton.getSingleton();
                System.out.println(singleton2.hashCode());
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            service.submit(task);
        }
        service.shutdown();
    }
}
