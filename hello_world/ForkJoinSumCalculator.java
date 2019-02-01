package hello_world;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * Created by shenhaizhilong on 7/8/2017.
 */
public class ForkJoinSumCalculator extends java.util.concurrent.RecursiveTask<Long>
{
    private final int THRESHOLD = 10000;
    private final long[] numbers;
    private final int start;
    private final int end;

    private ForkJoinSumCalculator(long[] numbers, int start, int end)
    {
        this.numbers = numbers;
        this.start = start;
        this.end   = end;
    }
    public ForkJoinSumCalculator(long[] numbers)
    {
        this(numbers, 0, numbers.length);
    }

    @Override
    protected Long compute()
    {
        int length = end - start;
        if(length <= THRESHOLD)
        {
            return computeSequentially();
        }

        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start+length/2);
        leftTask.fork(); //利用另外一个ForkJoinPool 线程来异步执行新创建的子任务
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start+length/2, end);
        Long rightResult = rightTask.compute();  // 同步执行另外一个子任务
        Long leftResult = leftTask.join(); // 读取第一个子任务的结果，如果尚未完成就等待
        return rightResult + leftResult;

    }

    private long computeSequentially()
    {
        long sum=0L;
        for(int i = start; i< end; i++)
        {
            sum +=numbers[i];
        }
        return sum ;
    }

    public static long forkJoinSum(long n)
    {
        long[] numbers = LongStream.rangeClosed(1,n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args)
    {
        long n = 10000000L;
        System.out.println("ForkJoin sum done in " + ParallelStream.measureSumPerf(ForkJoinSumCalculator::forkJoinSum, n) + "ms");
    }
}
