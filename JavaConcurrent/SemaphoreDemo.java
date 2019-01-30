package JavaConcurrent;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 17:08
 */
public class SemaphoreDemo {
    private static final Semaphore semp = new Semaphore(5);
    private static class Task implements Runnable
    {
        @Override
        public void run() {
            try
            {
                semp.acquire();
                Date date = new Date();
                System.out.println(" Thread " + Thread.currentThread().getId() + " running " + date.toString() );
                Thread.sleep(2000);
                semp.release();
            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Task task = new Task();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executorService.submit(task);
        }

        executorService.shutdown();
    }
}
