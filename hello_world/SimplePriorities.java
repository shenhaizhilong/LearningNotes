package hello_world;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class SimplePriorities implements Runnable
{
    private int countDown = 5;
    private volatile double d; // no optimization
    private int priority;
    public SimplePriorities(int priority){this.priority = priority;}

    @Override
    public String toString()
    {
        return Thread.currentThread() + ":" + countDown;
    }
    public void run()
    {
        Thread.currentThread().setPriority(priority);
        while (true)
        {
            for (int i = 0; i < 100000; i++) {
                d +=(Math.PI + Math.E) /(double)i;
                if(i%1000==0)
                {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown ==0) return;
        }
    }

    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
