package DesignPattern.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * thread  safe singleton class
 * @author: shenhaizhilong
 * @date: 2019/1/14 14:14
 *
 *推荐使用，线程安全
 * double check locking
 *
 */
public final class SingletonDoubleCheckLocking {
    //  volatile 确保可见性与有序性
    private static volatile SingletonDoubleCheckLocking ourInstance;
    // 禁止类外部调用构造函数
    private SingletonDoubleCheckLocking() {
        // 禁止通过反射实例化
        if(ourInstance != null)
        {
            throw new IllegalStateException("Already initialized");
        }
    }

    // double check locking  technology
    public static SingletonDoubleCheckLocking getInstance() {
        if(ourInstance ==  null)
        {
            // 只对关键代码进行同步，减小锁持有时间和范围,提高效率
            synchronized (SingletonDoubleCheckLocking.class)
            {
                if(ourInstance == null)
                {
                    ourInstance = new SingletonDoubleCheckLocking();
                }
            }
        }

        return ourInstance;
    }


    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                SingletonDoubleCheckLocking singleton = SingletonDoubleCheckLocking.getInstance();
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
