package hello_world;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by shenhaizhilong on 7/8/2017.
 */

public class ParallelStream
{
    public static void main(String[] args)
    {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long measure = 100000000L;
        System.out.println("Iterative sum done in:" + measureSumPerf(ParallelStream::iterativeSum, measure) + "ms");
        System.out.println("Sequential sum done in:" + measureSumPerf(ParallelStream::sequentialSum, measure) + "ms");
        //System.out.println("Parallel  sum done in:" + measureSumPerf(ParallelStream::parallelSum, measure) + "ms");
        System.out.println("range  sum done in:" + measureSumPerf(ParallelStream::rangedSum, measure) + "ms");
        System.out.println("Parallel range  sum done in:" + measureSumPerf(ParallelStream::parallelRangedSum2, measure) + "ms");

    }
    public static long iterativeSum(long n)
    {
        long result = 0;
        for(long i=1L; i<=n; i++)
        {
            result+=i;
        }
        return  result;
    }
    public static long measureSumPerf(Function<Long,Long> adder, long n)
    {
        long faster = Long.MAX_VALUE;
        for(int i=0; i <10; i++)
        {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start)/1000000;
            System.out.println("Result: " + sum);
            faster = duration < faster ? duration: faster;
        }
        return faster;
    }

    public static long sequentialSum(long n)
    {
        return  Stream.iterate(1L, i->i+1).limit(n).reduce(0L, Long::sum);
    }

    public static long parallelSum(long n)
    {
        return Stream.iterate(1L,i->i+1).limit(n).parallel().reduce(0L,Long::sum);
    }
    public static long rangedSum(long n)
    {
        return LongStream.rangeClosed(1L, n).reduce(0L, Long::sum);
    }
    public static long parallelRangedSum2(long n)
    {
        return LongStream.rangeClosed(1L,n).parallel().reduce(0L,Long::sum);
    }
}
