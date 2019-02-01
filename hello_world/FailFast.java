package hello_world;
import java.util.*;
/**
 * Created by shenhaizhilong on 4/28/2017.
 */
public class FailFast
{
    public static void main(String[] args)
    {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("An object");
        try {
            String s = it.next();
        }catch (ConcurrentModificationException e)
        {
            System.out.println(e);
        }
    }
}
