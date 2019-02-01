package ThreadTest;

import java.util.Random;


public class ThreadSafePrintln extends Thread {

    private int n = 5;
    @Override
    public synchronized void run()
    {
        Random random = new Random(47);
        int a = random.nextInt(100);

        try
        {

            Thread.sleep(a);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("i = " + (n--) + " Thread Name:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadSafePrintln threadSafePrintln = new ThreadSafePrintln();
        Thread t1 = new Thread(threadSafePrintln);
        Thread t2 = new Thread(threadSafePrintln);
        Thread t3 = new Thread(threadSafePrintln);
        Thread t4 = new Thread(threadSafePrintln);
        Thread t5 = new Thread(threadSafePrintln);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
