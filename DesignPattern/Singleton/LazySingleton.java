package DesignPattern.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/24 19:54
 *
 *
 * 懒汉单例模式 --> 延迟加载; 兄弟别急咱等会儿再加载
 * 第一次调用getSingleton 的时候，该单例被创建
 */
public final class LazySingleton {
    private static  LazySingleton singleton;

    // private constructor， forbidden to  call construction out side of this class
    private LazySingleton()
    {
        // 禁止通过反射实例化
        if(singleton != null)
        {
            throw new IllegalStateException("Already initialized");
        }
    }

    // 线程安全但是效率很低，下一个线程想要取得对象必须要等上一个线程执行完毕
    public synchronized static LazySingleton getSingleton()
    {

        if(singleton == null)
        {
            singleton = new LazySingleton();
        }

        return singleton;
    }


    //非线程安全
    public  static LazySingleton getSingleton2()
    {
            if(singleton == null)
            {
                // 只对关键代码进行同步，减小锁持有时间和范围,提高效率
                synchronized(LazySingleton.class) {
                    singleton = new LazySingleton();
                }
            }

        return singleton;
    }

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                LazySingleton singleton = LazySingleton.getSingleton2();
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
