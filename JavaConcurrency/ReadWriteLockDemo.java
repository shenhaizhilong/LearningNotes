package JavaConcurrency;

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
            System.out.println("Thread id:" + Thread.currentThread().getId() +  " Read thread get the lock, and do this job");
            Thread.sleep(1000);
            System.out.println("Thread id:" + Thread.currentThread().getId() +  " this job cost 1s");
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
            System.out.println("Thread id:" + Thread.currentThread().getId() +  " write thread get the lock, and do this job");
            Thread.sleep(1000);
            System.out.println("Thread id:" + Thread.currentThread().getId() +  " this job cost 1s");
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
                readWriteLockDemo.handleRead(readLock);  // 读锁
             //   readWriteLockDemo.handleRead(lock);  // 重入锁
            }
        };

        Runnable write = new Runnable() {
            @Override
            public void run() {
                readWriteLockDemo.handleWrite(writeLock, new Random().nextInt()); // 写锁
              //  readWriteLockDemo.handleWrite(lock, new Random().nextInt());  //重入锁
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(read).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(write).start();
        }

    }
}
