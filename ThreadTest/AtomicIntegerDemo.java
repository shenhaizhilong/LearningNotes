package ThreadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    private static AtomicInteger integer = new AtomicInteger();
    public static class AddThread implements Runnable
    {
        @Override
        public void run()
        {
            for (int i = 0; i < 10000; i++) {
                integer.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AddThread());
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println("integer is:" + integer.get());
    }
}
