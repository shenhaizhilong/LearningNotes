package hello_world;
import java.util.*;
import java.util.concurrent.CountDownLatch;


/**
 * Created by shenhaizhilong on 4/26/2017.
 */
public class CountedString
{
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id =0;
    public CountedString(String str)
    {
        s = str;
        created.add(s);
        for(String s2: created)
        {
            if(s2.equals(s))
                id++;
        }

    }
    public String toString()
    {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }
    public int hashCode()
    {
        int results = 17;
        results = 37*results + s.hashCode();
        results = 37*results + id;
        return results;
    }
    public boolean equals(Object o)
    {
        return o instanceof CountedString && s.equals(((CountedString)o).s) && id == ((CountedString)o).id ;

    }
    public static void main(String[] args)
    {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i=0; i<cs.length; i++)
        {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for(CountedString cString :cs)
        {
            System.out.println("Looking up " + cString);
            System.out.println(cString);
        }
    }
}
