package DesignPattern.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/24 20:44
 *
 * 静态代码块在使用类的时候已经执行过了，所以可以用静态代码块的特性来实现
 *
 */
public final class StaticCodeBlockSingleton {

    private static volatile StaticCodeBlockSingleton singleton;
    private StaticCodeBlockSingleton()
    {
        // 禁止通过反射实例化
        if(singleton != null)
        {
            throw new IllegalStateException("Already initialized");
        }
    }

    // static code block
    static {
        try
        {
            singleton = new StaticCodeBlockSingleton();
        }catch (Exception ex)
        {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }

    }

    public static StaticCodeBlockSingleton getSingleton()
    {
        return singleton;
    }


    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                StaticCodeBlockSingleton singleton = StaticCodeBlockSingleton.getSingleton();
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
