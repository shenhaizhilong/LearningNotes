package hello_world;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class FixedThreadPool
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
