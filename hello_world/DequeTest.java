package hello_world;

/**
 * Created by shenhaizhilong on 4/25/2017.
 */
public class DequeTest
{
    static void fillTest(Deque<Integer> deque)
    {
        for (int i=20; i<27; i++)
        {
            deque.addFirst(i);
        }
        for (int i=50; i<55; i++)
            deque.addLast(i);
    }
    public static void main(String[] args)
    {
        Deque<Integer> di = new Deque<>();
        fillTest(di);
        System.out.println(di);
        while (di.size()!=0)
        {
            System.out.print(di.removeFirst() + " ");
        }

        System.out.println();
        fillTest(di);
        System.out.println(di.getFirst());
        System.out.println(di.getLast());
        while (di.size()!=0)
        {
            System.out.print(di.removeLast() + " ");
        }
    }
}
