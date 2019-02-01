package ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock {
    public static ReentrantLock lock = new ReentrantLock();
    public static int count=0;
    public static class  AddThread implements Runnable
    {
        @Override
        public void run()
        {

            for (int i = 0; i < 1000000; i++) {
                lock.lock();
                try
                {
                    count++;
                }finally {
                    lock.unlock();
                }

            }

        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new AddThread());
        Thread thread1 = new Thread(new AddThread());
        thread1.start();
        thread1.join();
        thread.start();
        thread.join();

        System.out.println(count);
    }
}
