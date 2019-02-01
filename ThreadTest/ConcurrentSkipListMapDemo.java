package ThreadTest;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new ConcurrentSkipListMap<>();
        for (int i = 0; i < 20; i++) {
            int a = new Random().nextInt(100);
            System.out.println(a);
            map.put(i, a);

        }

        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
        }

        System.out.println(map.containsValue(10));

        for (Integer i :
                map.values()) {
            System.out.println(i);
        }
    }
}
