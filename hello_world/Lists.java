package hello_world;
import java.util.*;
/**
 * Created by shenhaizhilong on 4/25/2017.
 */
public class Lists
{
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;
    public static void basicTest(List<String> a)
    {
        a.add(1,"x");
        testVisual(a);
        a.add("x");
        testVisual(a);
        b = a.contains(("1"));
        System.out.println("Contains 1:" + b);
        s = a.get(1);
        System.out.println("the value of index 1:" + s);

        i = a.indexOf("x");
        System.out.println("the index of value x is:" + i);
        b= a.isEmpty();
        System.out.println("is empty?: " + b);
        it = a.iterator();
        lit  = a.listIterator();
        lit = a.listIterator(3);
        i = a.lastIndexOf("x");
        a.remove(1);
        a.remove("x");
        a.set(1,"Y");
        i = a.size();
        a.clear();
    }
    public static void iterMotion(List<String> a)
    {
        ListIterator<String> it = a.listIterator();
        b = it.hasNext();
        b= it.hasPrevious();
        s = it.next();
        i = it.nextIndex();
        s = it.previous();
        i = it.previousIndex();
    }
    public static void iterManipulation(List<String> a)
    {
        ListIterator<String> it = a.listIterator();
        it.add("47");
        it.next();
        it.remove();
        it.next();
        it.set("47");
    }
    public static void testVisual(List<String> a)
    {
        System.out.println(a);

    }

    public static void main(String[] args)
    {

        List<String> a =  new LinkedList<>();
        a.add("test");
        a.add("haha");
        basicTest(a);
        testVisual(a);
    }


}
