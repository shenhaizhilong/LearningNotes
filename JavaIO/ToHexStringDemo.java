package JavaIO;

public class ToHexStringDemo {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            int v = i &0xff;
            if(v<16) System.out.print('0');
            System.out.println(Integer.toHexString(i));
        }
    }
}
