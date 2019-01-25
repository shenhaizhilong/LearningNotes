package javavm;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author: shenhaizhilong
 * @date: 2018/11/4 22:06
 */
public class TreeMapTest {
    public static void main(String[] args) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            treeMap.put(i,i);
        }

        SortedMap<Integer, Integer> sortedMap = treeMap.tailMap(4);
        System.out.println(treeMap.size());
        System.out.println(sortedMap);
        System.out.println(treeMap);
    }
}
