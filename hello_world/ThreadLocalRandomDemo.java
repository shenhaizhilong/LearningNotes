package hello_world;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomDemo {
    public static void main(String[] args) {


        Thread[] threads = new Thread[10];
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
                System.out.println(threadLocalRandom.nextInt(100) + ", " + Thread.currentThread().getId());
                try
                {
                    Thread.sleep(10);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        };
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        Runnable runnable1 = ()-> System.out.println(Thread.currentThread().getId());
        runnable1.run();

    }
}
