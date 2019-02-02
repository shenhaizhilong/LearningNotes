package JavaConcurrency;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/30 20:13
 */
public class DeadLock {

    private static final Object obj1 = new Object();
    private static final Object obj2 = new Object();

    private static class WorkerA implements Runnable
    {
        @Override
        public void run() {
            synchronized (obj1)
            {
                System.out.println("Thead A get the lock on obj1, try to get the lock on obj2 ");
                try
                {
                    Thread.sleep(1000);
                    synchronized (obj2)
                    {
                        System.out.println("Thead A get the lock on obj1 and obj2 ");
                    }
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static class WorkerB implements Runnable
    {
        @Override
        public void run() {
            synchronized (obj2)
            {
                System.out.println("Thead B get the lock on obj2, try to get the lock on obj1 ");
                try
                {
                    Thread.sleep(1000);
                    synchronized (obj1)
                    {
                        System.out.println("Thead B get the lock on obj2 and obj1 ");
                    }
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new WorkerA(), "Worker A Thread");
        Thread threadB = new Thread(new WorkerB(), "Worker B Thread");
        threadA.start();
        threadB.start();
    }
}
