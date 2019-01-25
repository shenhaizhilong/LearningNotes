package constantpool;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/24 18:21
 */
public class StringDemo {
    public static void main(String[] args) {
        String a = "A " + "B" + "Name";
        System.out.println(a);

        int x = 0;
        String literal = "Value is" + x + a;

    }
}
