package ThreadTest;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void read()
    {
        try
        {
            readWriteLock.readLock().lock();
            System.out.println("Get the ReadWriteLock " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void write()
    {
        try
        {
            readWriteLock.writeLock().lock();
            System.out.println("Get the ReadWriteLock " + Thread.currentThread().getName() +" " + System.currentTimeMillis());
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {

        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
        Runnable runnablea = new Runnable() {
            @Override
            public void run() {
                readWriteLockTest.read();

            }
        };

        Runnable runnableb = new Runnable() {
            @Override
            public void run() {
                readWriteLockTest.write();
            }
        };
        Thread threada = new Thread(runnablea, "A");
        Thread threadb = new Thread(runnablea, "B");
        Thread threadc = new Thread(runnablea, "C");
        threada.start();
        threadb.start();
        threadc.start();

        Thread threadd = new Thread(runnableb, "D");
        Thread threade = new Thread(runnableb, "E");
        Thread threadf = new Thread(runnableb, "F");
        threadd.start();
        threade.start();
        threadf.start();



    }
}
