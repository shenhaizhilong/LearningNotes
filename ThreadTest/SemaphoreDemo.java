package ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable {
    private static Semaphore semaphore = new Semaphore(5);

    @Override
    public void run()
    {
        try
        {
            System.out.println(Thread.currentThread().getId() + " try to acquire the semaphore");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getId() + " Got the semaphore");
            System.out.println(Thread.currentThread().getId() + " Sleep 2s");
            Thread.sleep(2000);
            System.out.println("current thread " + Thread.currentThread().getId() + " done!");
            semaphore.release();

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            executorService.submit(demo);
        }
    }
}
