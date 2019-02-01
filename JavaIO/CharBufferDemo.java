package JavaIO;

import java.nio.CharBuffer;

public class CharBufferDemo {
    public static void main(String[] args) {


        //char type is 16bit, it's range is 0~65535
        char[] chars = new char[123];
        for (int i = 0; i < 123; i++) {
            chars[i] = (char)i;
        }
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        System.out.println(charBuffer.toString());


    }
}
