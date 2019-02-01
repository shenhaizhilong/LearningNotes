package hello_world;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class SleepingTask extends LiftOff
{
    public void run()
    {
        try{
            while (countDown-->0)
            {
                System.out.println(status());
                //Old-style
                //Thread.sleep(100);
                //Java SE5/6 style
                TimeUnit.MILLISECONDS.sleep(100);

            }
        }catch (InterruptedException e)
        {
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SleepingTask());
        }
        executorService.shutdown();
    }
}
