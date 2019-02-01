package hello_world;
import java.util.concurrent.*;
import java.util.*;
/**
 * Created by shenhaizhilong on 4/25/2017.
 */
public class Maps
{
    public static void printKeys(Map<Integer,String> map)
    {
        System.out.println("Size =" + map.size() + ",");
        System.out.println("Keys:");
        System.out.println(map.keySet());
    }
    public static void test(Map<Integer,String> map)
    {
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(29));
        //map has 'Set' behavior for keys;
        map.putAll(new CountingMapData(29));
        printKeys(map);
        System.out.println("Values:");
        System.out.println(map.values());
        System.out.println("Keys and Values:");
        System.out.println(map);
        System.out.println("map.containsKey(11):" + map.containsKey(11));
        System.out.println("map.get(11):" + map.get(11));
        System.out.println("map.containsValue(\"F0\"):" + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        System.out.println("First key in map:" + key);
        map.remove(key);
        System.out.println("remove one key");
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty():"  + map.isEmpty());
        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty():"  + map.isEmpty());

    }
    public static void main(String[] args)
    {
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
        test(new IdentityHashMap<>());
        test(new ConcurrentHashMap<>());
        test(new WeakHashMap<>());
    }
}
