package suggestions151;

/**
 * @author: shenhaizhilong
 * @date: 2018/6/26 10:18
 */
public class HashDemo {
    public static void main(String[] args) {
        int n = 7;
        for (int i = 0; i < 15; i +=2) {
            System.out.println("i = " + i + ", mod= " + i%n);
        }
    }
}
