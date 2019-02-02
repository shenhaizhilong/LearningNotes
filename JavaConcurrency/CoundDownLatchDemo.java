package JavaConcurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 17:42
 */
public class CoundDownLatchDemo {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    private static class Task implements Runnable
    {
        @Override
        public void run() {
            try {
                Thread.sleep((new Random().nextInt(10))*1000);
                System.out.println("Finished " + Thread.currentThread().getId() + " thread");
                countDownLatch.countDown();

            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.submit(task);
        }

        // waiting all tasks finished.
        countDownLatch.await();
        System.out.println("fire!");
        service.shutdown();
    }
}
