package hello_world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by shenhaizhilong on 5/5/2017.
 */

public class ExecutionLambda
{
    public static String processFile(BufferedReaderProcessor p, String fileName) throws IOException
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            return p.process(bufferedReader);
        }
    }

    public static void main(String[] args) throws IOException
    {
        String fileName = "F:\\\\Users\\\\shenhaizhilong\\\\Test\\\\test10.txt";
        String firstLine = processFile((BufferedReader br) -> br.readLine(), fileName);
        System.out.println(firstLine);
        String twoLine = processFile((BufferedReader br)-> br.readLine() + br.readLine(), fileName);
        System.out.println(twoLine);

        List<Integer> list = Arrays.asList(1,2,3,5,6,4);
        List<Integer> tList = filter(list, (Integer i)-> i%2==0);
        System.out.println(tList);
        System.out.println("forEach test");
        forEach(Arrays.asList(1,2,3,4), (Integer i)-> System.out.print(i +" "));

        System.out.println("map function test");
        System.out.println(map(Arrays.asList("aa","aaa", "abcde"), (String s)-> s.length()));

        List<Long> list1 = new ArrayList<>();
        IntPredicate predicate = (int i) -> i%2==0;
        System.out.println(predicate.test(100));  //without boxing
        Predicate<Integer> predicate1 = (Integer i) -> i%2==1;
        System.out.println(predicate1.test(1000));

    }
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate)
    {
        List<T> tList = new ArrayList<>();
        for(T t: list)
        {
            if(predicate.test(t))
            {
                tList.add(t);
            }
        }
        return tList;
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer)
    {
        for(T t: list)
        {
            consumer.accept(t);
        }
    }
    public static <T,R> List<R> map(List<T> list, Function<T,R> f)
    {
        List<R> result = new ArrayList<>();
        for(T s:list)
        {
            result.add(f.apply(s));
        }
        return result;
    }
}
