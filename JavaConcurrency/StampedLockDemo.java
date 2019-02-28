package JavaConcurrency;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/26 18:23
 */
public class StampedLockDemo {
    public static void main(String[] args) throws InterruptedException {

        final StampedLock lock = new StampedLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long stamp = lock.writeLock();
              //  LockSupport.parkNanos(100_100_000_000L); // cpu use will be 100%
                lock.unlockWrite(stamp);
            }
        };

        new Thread(runnable).start();
        Thread.sleep(300);

        for (int i = 0; i < 3; i++) {
            new Thread(new OccupiedCPUReadThread(lock)).start();
        }


    }


    private static class OccupiedCPUReadThread implements Runnable{

        private StampedLock lock;
        public OccupiedCPUReadThread(StampedLock lock)
        {
            this.lock = lock;
        }
        @Override
        public void run() {
            Thread.currentThread().interrupt();
            long stamp = lock.readLock();
            System.out.println(Thread.currentThread().getName() + " get the read lock");
            lock.unlockRead(stamp);
        }
    }
}
