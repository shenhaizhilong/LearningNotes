package pocketJava8;

import java.util.Arrays;

/**
 * @author: shenhaizhilong
 * @date: 2018/8/3 9:13
 */
public class CompoundAssignmentOperators {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,10};
        int j = 5;
        a[j++] += 2;
        System.out.println(j);
        System.out.println(a[5]);

        j = 3;
        a[j++] = a[j++] + 2;
        System.out.println(j);
        System.out.println(Arrays.toString(a));
    }
}
