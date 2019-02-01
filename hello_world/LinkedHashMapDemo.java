package hello_world;
import java.util.*;

/**
 * Created by shenhaizhilong on 4/25/2017.
 */
public class LinkedHashMapDemo
{
   public static void main(String[] args)
   {
       LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>(new CountingMapData(9));
       System.out.println(linkedHashMap);
       // Least recently used order
       linkedHashMap = new LinkedHashMap<>(16,0.75f, true);
       linkedHashMap.putAll(new CountingMapData(9));
       System.out.println(linkedHashMap);
       for(int i=0; i< 6; i++)
       {
          System.out.println(linkedHashMap.get(i));
       }
       System.out.println(linkedHashMap);
       linkedHashMap.get(0);
       System.out.println(linkedHashMap);
       Iterator<Integer> iterator = linkedHashMap.keySet().iterator();
       while (iterator.hasNext())
       {
           System.out.println(iterator.next());
       }
   }
}
