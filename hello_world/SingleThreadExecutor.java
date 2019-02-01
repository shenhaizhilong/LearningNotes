package hello_world;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
public class SingleThreadExecutor
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
