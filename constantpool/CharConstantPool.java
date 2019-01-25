package constantpool;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/24 16:21
 */
public class CharConstantPool {
    public static void main(String[] args) {

        //Character cache in the range \u0000 to \u007F
        Character c = 'a';
        Character b = 'a';
        System.out.println(c == b);

        c = new Character('a');
        b = new Character('a');
        System.out.println(c == b);
    }
}
