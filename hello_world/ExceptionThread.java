package hello_world;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class ExceptionThread implements Runnable
{
    public void run()
    {
        throw new RuntimeException();
    }

    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
    }
}
