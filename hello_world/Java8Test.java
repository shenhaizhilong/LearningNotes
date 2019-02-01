package hello_world;

import java.io.File;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by shenhaizhilong on 5/3/2017.
 */
public class Java8Test
{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable runnable2 = ()-> System.out.println("Hello,world!");
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        //System.out.println(hiddenFiles);
        for (File f :
                hiddenFiles) {
            System.out.println(f.getAbsolutePath());
        }

        //函数接口：只有一个抽象方法的接口，哪怕它有多个默认方法


        //lambda function
        Runnable runnable = () -> System.out.println("Hello, world!1");

        // anonymous class
        Runnable runnable1 = new Runnable() {
            @Override
            public void run()
            {
                System.out.println("Hello, world!2");
            }
        };
        process(runnable);
        process(runnable1);
        int[] iArr = {1,2,3,334,44,5,6,7,8,9};
        Arrays.stream(iArr).forEach(System.out::println);
        Arrays.stream(iArr).map(x -> (x%2==0? x: x*2)).forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,0,12);
        numbers.forEach((Integer value) -> System.out.println(value));
        for (Integer number : numbers) {
            System.out.println(number*number);
        }

        int num = 10;
        Function<Integer,Integer> stringConvert =(from)->from*num;
        System.out.println(stringConvert.apply(10));

        // 使用局部变量
        final int portNumber = 443;
        Runnable runnable3 = ()-> System.out.println(portNumber);
        runnable3.run();

        IntPredicate evenNumber = (int i) -> (i&1)==1;
        for(int i=1; i< 900; i++)
        {
            System.out.println(evenNumber.test(i));
        }
        //构造函数引用
        Supplier<Apple> c1 = Apple::new;
        Apple apple = c1.get();
        System.out.println(apple);

        //equal to
        Supplier<Apple> c2 = ()-> new Apple();
        Apple apple1 = c2.get();
        System.out.println(apple1);

        //
        Function<Integer,Apple> c3 = Apple::new;
        Apple apple2 = c3.apply(100);
        System.out.println(apple2);
        List<Integer> weights = Arrays.asList(1,2,4,9,8,9);
        List<Apple> appleList = map(weights,Apple::new);
        System.out.println(appleList);

        BiFunction<Integer,String,Apple> c4 = Apple::new;
        Apple apple3 = c4.apply(100,"Red");


        //method 1传递代码

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(155, "red"),
                new Apple(120, "red"),
                new Apple(20,"red"));
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        //method 2 anonymous class
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2)
            {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        System.out.println(inventory);
        //method 3 lambda expression
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);
        //auto deduce
        inventory.sort((a1, a2)->a1.getColor().compareTo(a2.getColor()));
        System.out.println(inventory);

        //method 4 using Comparing
        Comparator<Apple> c = Comparator.comparing((Apple a)->a.getWeight());
        inventory.sort(c);
        System.out.println(inventory);


        inventory.sort(comparing((a)->a.getColor()));
        System.out.println(inventory);

        //method 5
        inventory.sort(comparing(Apple::getColor));

        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        System.out.println(inventory);

        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);

        // and then function

        Function<Integer,Integer> f1 = x->x+1;
        Function<Integer,Integer> g = x->2*x;
        Function<Integer,Integer> h = f1.andThen(g);
        int r = h.apply(100);
        System.out.println(r);
        Function<Integer,Integer> m = f1.compose(g);
        r = m.apply(100);
        System.out.println(r);


        int[] iArr2 = {1,2,3,334,44,5,6,7,8,9};
        Arrays.stream(iArr2).map((x) -> x*x).forEach(System.out::println);
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }

        integerList.stream().map((x) -> x.toString()).forEach(System.out::print);

        System.out.println();
        //
        int[] arr = new int[10000000];
        Random random = new Random(47);

        Arrays.parallelSetAll(arr, x-> random.nextInt());
        System.out.println(arr[0] +" " +arr[1]);

        long count   = IntStream.range(0,10000000).filter((x)->x%2==0).count();
        System.out.println(count);
        count = IntStream.range(0,10000000).parallel().filter((x)->x%2==0).count();
        System.out.println(count
        );


        Optional<Integer> firstNum = Arrays.asList(1,2,3,4,5,6,7,9).stream().map(x -> x*x).filter(x -> x % 3 == 0).findFirst();
        if(firstNum.isPresent()) System.out.println(firstNum.get());

        int sum = IntStream.range(0,11).reduce(0, (a,b) -> a +b );
        System.out.println(sum);
        sum = IntStream.range(0,11).sum();
        System.out.println(sum);
        Thread.sleep(10*1000);

        System.out.println("parallel Sum test:");
        long N = 10000000L;
//        System.out.println(parallelSum(N));
//        System.out.println(parallelSum2(N));

        measureSumPerf(Java8Test::iterativeSum, N);
       // measureSumPerf(Java8Test::parallelSum, N);
        measureSumPerf(Java8Test::parallelSum2, N);
        Thread.sleep(10*1000);
    }

    public static List<Apple> map(List<Integer> list,Function<Integer,Apple> f)
    {
        List<Apple> result = new ArrayList<>();
        for(Integer i:list)
        {
            result.add(f.apply(i));
        }
        return result;
    }

    public static void  process(Runnable runnable)
    {
        runnable.run();
    }

    public static long iterativeSum(long n)
    {
        long sum = 0L;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // iterate 有装箱拆箱操作所以慢
    public static long parallelSum(long n)
    {
        long ans = Stream.iterate(1L, i -> i +1).limit(n).parallel().reduce(0L, Long::sum);
        return ans;
    }

    // long steam 没有装箱拆箱操作
    public static long parallelSum2(long n)
    {
        long ans = LongStream.rangeClosed(1,n).parallel().sum();
        return ans;
    }


    public static long measureSumPerf(Function<Long,Long> adder, long n)
    {
        long start = System.nanoTime();
        long sum = -1;
        for (int i = 0; i < 10; i++) {
           sum = adder.apply(n);
        }
        long end = System.nanoTime();
        System.out.println((end - start)/1_000_000);
        return sum;
    }
}
