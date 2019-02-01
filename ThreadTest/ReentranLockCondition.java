package ThreadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockCondition implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run()
    {

        try
        {

            lock.lock();
            System.out.println("get the lock");
            condition.await();
            System.out.println("Thread is going on");
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    public static void main(String[] args) {
        ReentranLockCondition t1 = new ReentranLockCondition();
        Thread t = new Thread(t1,"Thread T");
        t.start();
        try
        {
            System.out.println("Sleep 2s");
            Thread.sleep(2000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        lock.lock();
        System.out.println("Main thread get the lock");
        condition.signal();
        lock.unlock();
        System.out.println("Main thread unlock");
    }
}
