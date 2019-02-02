package JavaConcurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/7 16:43
 */
public class ReentrantLockCondition {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static class ConditionTask implements Runnable
    {
        @Override
        public void run() {
            try
            {
                System.out.println(" Thread " + Thread.currentThread().getName() + " get the lock");
                lock.lock();
                System.out.println(" Thread " + Thread.currentThread().getName() + " await");
                condition.await();
                System.out.println(" Thread " + Thread.currentThread().getName() + " get the signal");
                System.out.println(" Thread " + Thread.currentThread().getName() + " get the lock");
                System.out.println(" Thread " + Thread.currentThread().getName() + " finished the job");

            }catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTask task = new ConditionTask();
        Thread thread = new Thread(task, "t1");
        thread.start();
        System.out.println(" Thread " + Thread.currentThread().getName() + " sleep 2s");
        Thread.sleep(1000*2);
        System.out.println(" Thread " + Thread.currentThread().getName() + " get the lock");
        lock.lock();
        System.out.println(" Thread " + Thread.currentThread().getName() + " send the signal");
        condition.signal();
        lock.unlock();
        System.out.println(" Thread " + Thread.currentThread().getName() + " released the lock");
        System.out.println(" Thread " + Thread.currentThread().getName() + " finished the job");
    }
}
