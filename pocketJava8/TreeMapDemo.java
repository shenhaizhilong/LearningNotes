package pocketJava8;
import java.util.*;

/**
 * @author: shenhaizhilong
 * @date: 2018/7/13 10:15
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3,"Bob");
        treeMap.put(9, "Buf");
        treeMap.put(5,"Tomas");
        treeMap.put(1, "Tom");
        treeMap.put(12,"Alice");
        treeMap.put(7,"Tomas");
        Map.Entry<Integer, String> entry = treeMap.ceilingEntry(10);
        System.out.println(entry);

        Set<Map.Entry<Integer, String>> set = treeMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, String> myEntry = iterator.next();
            System.out.println(myEntry);
        }

        Map<Integer, String> map2 = new TreeMap<>(Comparator.reverseOrder());
        map2.putAll(treeMap);
        for (Map.Entry<Integer, String> entry1:
        map2.entrySet()){
            System.out.println(entry1);
        }

    }
}
