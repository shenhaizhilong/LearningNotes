package hello_world;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by shenhaizhilong on 5/1/2017.
 */
class TaskWithResult implements Callable<String>
{
    private int id;
    public TaskWithResult(int id)
    {
        this.id = id;
    }
    public String call()
    {
        return "result of  TaksWithResult " + id + " Thread Id:" + Thread.currentThread().getId();
    }
}
public class CallableDemo
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs: results)
        {
            try {
                //get() blocks until completion
                System.out.println(fs.get());
            }catch (InterruptedException e)
            {
                System.out.println(e);
                return;
            }catch (ExecutionException e)
            {
                System.out.println(e);
            }finally {
                executorService.shutdown();
            }
        }

    }
}
