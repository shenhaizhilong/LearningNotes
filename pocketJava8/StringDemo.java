package pocketJava8;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/15 22:51
 */
public class StringDemo {
    public static void main(String[] args) {
        String a = new String("demo");
        String b = a.intern();
        System.out.println(b);
    }
}
