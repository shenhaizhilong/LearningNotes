package hello_world;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shenhaizhilong on 7/8/2017.
 */
public class Java8Test8
{
    public static void doSomething(Runnable r){ r.run();}
    public static void doSomething(Task task) {task.execute();}

    public static void main(String[] args)
    {
        doSomething((Task) ()-> System.out.println("hello, task"));
        doSomething((Runnable) () -> System.out.println("hello, Runnable"));

        List<Point> points = Arrays.asList(new Point(2,2), null);
        //points.stream().map(p->p.getX()).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(12,3,4,5,6,7,8,9,0);

        List<Integer> results = numbers.stream().peek( x-> System.out.println("from stream: " + x)).map(x->x+17)
                .peek(x-> System.out.println("after map: " +x))
                .filter(x-> x%2==0).peek(x-> System.out.println("after filter: " + x))
                .limit(3).peek(x-> System.out.println("limit :" +x)).collect(Collectors.toList());
        System.out.println(results);

    }
}

interface Task
{
    public void execute();

}

