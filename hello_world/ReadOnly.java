package hello_world;
import java.util.*;

/**
 * Created by shenhaizhilong on 4/28/2017.
 */
public class ReadOnly
{
    static String[] strs= "one two three four five six one two".split(" ");
    static Collection<String> data = new ArrayList<>(Arrays.asList(strs));
    public static void main(String[] args)
    {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));
        System.out.println(c);
       // c.add("one");   //java.lang.UnsupportedOperationException
        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        System.out.println(lit.next());
        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));
        System.out.println(s);
        //s.add("one");   //java.lang.UnsupportedOperationException
        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<>(data));
        
    }
}
