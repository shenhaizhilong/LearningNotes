package JavaConcurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 16:11
 */
public class FairLock {
    private static ReentrantLock lock = new ReentrantLock(true); // fair lock
    //private static ReentrantLock lock = new ReentrantLock(); // unfair lock

    private static class Task implements Runnable
    {
        @Override
        public void run() {
            while (true)
            {
                try
                {
                    lock.lock();
                    System.out.println("Thread " + Thread.currentThread().getName() + " get the lock");
                    Thread.sleep(1000);
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
                finally {
                    lock.unlock();
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
