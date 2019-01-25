package DesignPattern.Singleton;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/24 19:39
 *
 * 非线程安全
 * 饿汉模式|着急模式 --> 立即加载，等不及了，所以称为饿汉模式
 *
 * 类被加载，静态实例变量立即被创建，但getSingleton 方法并没有同步，所以有可能会出现非线程安全问题
 *
 */

// final class
public final class EagerSingleton {
    // just create a single instance
    private static final EagerSingleton singleton = new EagerSingleton();

    // private constructor， forbidden to  call construction out side of this class
    private EagerSingleton()
    {
        // 禁止通过反射实例化
        if(singleton != null)
        {
            throw new IllegalStateException("Already initialized");
        }
    }

    public static EagerSingleton getSingleton()
    {
        try {
            Random random = new Random();
            int sec = random.nextInt(3)*1000;
            Thread.sleep(sec);
        }catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
        return singleton;
    }

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                EagerSingleton singleton = EagerSingleton.getSingleton();
                System.out.println(singleton.hashCode());
            }
        };

        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            service.submit(task);
        }
        service.shutdown();
    }

}
