package ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {
    public static ReentrantLock reentrantLock = new ReentrantLock(true);

    @Override
    public void  run()
    {
        while (true)
        {
            try
            {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + " Get the lock");
            }finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock, "T1");
        Thread t2 = new Thread(fairLock, "T2");
        t2.start();
        t1.start();

    }
}
