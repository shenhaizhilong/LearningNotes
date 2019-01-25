package JavaConcurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 17:22
 */
public class ReadWriteLockDemo {
    private int value;
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    public int handleRead(Lock currLock)
    {
        try
        {
            currLock.lock();
            Thread.sleep(1000);
        }catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }finally {
            currLock.unlock();
        }
        return value;
    }

    public void handleWrite(Lock currLock, int index)
    {
        try
        {
            currLock.lock();
            value = index;
            Thread.sleep(1000);
        }catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }finally {
            currLock.unlock();
        }
    }

    public static void main(String[] args) {

        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        Runnable read = new Runnable() {
            @Override
            public void run() {
              //  readWriteLockDemo.handleRead(readLock);
                readWriteLockDemo.handleRead(lock);
            }
        };

        Runnable write = new Runnable() {
            @Override
            public void run() {
              //  readWriteLockDemo.handleWrite(writeLock, new Random().nextInt());
                readWriteLockDemo.handleWrite(lock, new Random().nextInt());
            }
        };

        for (int i = 0; i < 20; i++) {
            new Thread(read).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(write).start();
        }
    }
}
