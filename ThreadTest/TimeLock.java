package ThreadTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


public class TimeLock implements Runnable
{
    public static ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run()
    {
        try {
            if(reentrantLock.tryLock(5, TimeUnit.SECONDS))
            {
                System.out.println("Get the lock and sleep 6s");
                Thread.sleep(7000);
            }
            else
            {
                System.out.println("Get the lock failed");
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            if(reentrantLock.isHeldByCurrentThread()){
                reentrantLock.unlock();
                System.out.println("finally released the lock");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TimeLock timeLock = new TimeLock();
        Thread thread = new Thread(timeLock);
        Thread thread1 = new Thread(timeLock);
        thread.start();
        thread1.start();



    }
}
