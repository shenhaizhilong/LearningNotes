package javavm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/24 10:34
 */
public class FakeGeneric {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(10);
        map.put("hello", "hello");
        map.put("world", "world");
        System.out.println(map.get("hello"));
        List<String> list = new LinkedList<>();
        list.add("wowo");
        list.add("tom");
        System.out.println(list.get(0));


    }
}
