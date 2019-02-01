package hello_world;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class CachedThreadPool
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
            System.out.println(executorService.isShutdown());
        }
        System.out.println("Waiting LiftOff");
        executorService.shutdown();
        System.out.println(executorService.isShutdown());
    }
}
