package hello_world;
import java.util.*;

/**
 * Created by shenhaizhilong on 4/28/2017.
 */
public class Synchronization
{
    public static void main(String[] args)
    {
        Collection<String> c = Collections.synchronizedCollection(new ArrayList<>());
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<String> s = Collections.synchronizedSet(new HashSet<String>());
        Set<String> ss = Collections.synchronizedSortedSet(new TreeSet<>());
        Map<String,String> m = Collections.synchronizedMap(new HashMap<>());
        Map<String,String> sm = Collections.synchronizedSortedMap(new TreeMap<>());
        c.add("one");
        System.out.println(c);
    }
}
