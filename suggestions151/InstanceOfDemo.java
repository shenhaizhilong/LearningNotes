package suggestions151;

import java.util.Arrays;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/27 9:49
 */
public class InstanceOfDemo {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        Object b = a;
        System.out.println((b instanceof Object[]));
        System.out.println((b instanceof byte[]));
        System.out.println((b instanceof int[]));

        String str = "str";
        String str2 = new String("str");
        System.out.println(str == str2);
        String str3 = str2.intern();
        System.out.println(str == str3);
        System.out.println(Arrays.toString(a));

    }
}
