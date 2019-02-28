package DesignPattern.Singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/28 17:35
 */
public final class CASSingleton {

    private static   volatile AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

    private CASSingleton()
    {
        // 禁止通过反射实例化
        if(INSTANCE.get() != null)
        {
            throw new IllegalStateException("Already initialized");
        }
    }

    public static CASSingleton getInstance()
    {
        for(;;)
        {
            CASSingleton curr = INSTANCE.get();
            if(curr != null)return curr;
            curr = new CASSingleton();
            if(INSTANCE.compareAndSet(null, curr))
            {
                return curr;
            }
        }
    }




    public static void main(String[] args) {


        CountDownLatch countDownLatch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                try
                {
                    System.out.println("Count:" + countDownLatch.getCount());
                    countDownLatch.await();
                    CASSingleton   casSingleton = CASSingleton.getInstance();
                    System.out.println("HashCode:" + casSingleton.hashCode());
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }

            }
        };
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(runnable);
        }

        service.shutdown();
    }
}
