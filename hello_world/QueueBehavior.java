package hello_world;
import java.util.concurrent.*;
import java.util.*;

/**
 * Created by shenhaizhilong on 4/25/2017.
 */
public class QueueBehavior
{
    private static int count = 10;
    static <T> void test(Queue<T> queue, IGenerator<T> generator)
    {
        System.out.println(queue.getClass() + ":");
        for (int i=0; i<count; i++)
        {
            queue.offer(generator.next());

        }
        while (queue.peek()!=null)
        {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
    static class Gen implements IGenerator<String>
    {
        String[] s = ("one two three four five six seven eight nine ten").split(" ");
        int i;
        public String next(){
            return s[i++];
        }
    }
    public static void main(String[] args)
    {
        test(new LinkedList<>(), new Gen());
        test(new PriorityQueue<>(), new Gen());
        test(new ArrayBlockingQueue<>(count), new Gen());
        test(new ConcurrentLinkedQueue<>(), new Gen());
        test(new LinkedBlockingQueue<>(), new Gen());
        test(new PriorityBlockingQueue<>(), new Gen());
        LinkedList<String> a = new LinkedList<>();
        
    }
}
