package JavaConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/29 21:24
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try
                    {
                        System.out.println("Thread: " + Thread.currentThread().getId() + "  sleep 1s");
                        Thread.sleep(1000);
                    }catch (InterruptedException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
        System.out.println("**********");
        ExecutorService service2 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            service2.submit(new Runnable() {
                @Override
                public void run() {
                    try
                    {
                        System.out.println("Thread: " + Thread.currentThread().getId() + "  sleep 1s");
                        Thread.sleep(1000);
                    }catch (InterruptedException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            });
        }
        service2.shutdown();

    }
}
