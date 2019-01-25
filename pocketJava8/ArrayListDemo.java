package pocketJava8;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: shenhaizhilong
 * @date: 2018/7/25 18:52
 */
public class ArrayListDemo {
    public static void main(String[] args) {

        List<Integer>[] a = new List[5];
        a[0] = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            a[0].add(i);
        }

        System.out.println(a[0]);
    }
}
