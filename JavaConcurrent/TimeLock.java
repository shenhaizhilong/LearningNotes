package JavaConcurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 16:15
 */
public class TimeLock {
    private static ReentrantLock lock = new ReentrantLock();

    private static class Task implements Runnable
    {
        @Override
        public void run() {
            while (true)
            {
                try
                {
                    if(lock.tryLock(2, TimeUnit.SECONDS))
                    {
                        System.out.println("Thread " + Thread.currentThread().getName() + " get the lock");
                        System.out.println("Thread " + Thread.currentThread().getName() + " sleep 6s");
                        Thread.sleep(1000*6);
                    }else{
                        System.out.println("Thread " + Thread.currentThread().getName() + " failed to get the lock");
                    }

                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }finally {
                    if (lock.isHeldByCurrentThread())
                    {
                        lock.unlock();
                        System.out.println("Thread " + Thread.currentThread().getName() + " released the lock");
                    }

                }
            }
        }
    }
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread1 = new Thread(task, "t1");
        Thread thread2 = new Thread(task, "t2");
        thread1.start();
        thread2.start();

    }
}
