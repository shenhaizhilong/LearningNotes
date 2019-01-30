package JavaConcurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/30 19:35
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private final long threshold = 100000;
    private long start, end;
    public ForkJoinDemo(long start, long end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long ans = 0;
        if(end - start <= threshold)
        {
            for(long i = start; i <= end; i++)
            {
                ans += i;
            }
        }else {
            long mid = (start + end) >>> 1;
            ForkJoinDemo leftTask = new ForkJoinDemo(start, mid);
            ForkJoinDemo rightTask = new ForkJoinDemo(mid +1, end);
            leftTask.fork();
            rightTask.fork();
            ans = leftTask.join() + rightTask.join();
        }
        return ans;
    }

    public static void main(String[] args) {
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0, Integer.MAX_VALUE);
        ForkJoinPool pool = new ForkJoinPool();
        Future<Long> ans = pool.submit(forkJoinDemo);
        try
        {
            System.out.println(ans.get());
        }catch (InterruptedException | ExecutionException ex)
        {
            ex.printStackTrace();
        }

    }
}
