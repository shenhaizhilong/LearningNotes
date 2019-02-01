package JavaIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class CharsetDemo {
    public static void main(String[] args) {
        Charset charset = Charset.forName("utf-8");
        Set<String> set = charset.aliases();
        for (String s :
                set) {
            System.out.println(s);
        }
        System.out.println("******************************");
        Map<String, Charset> charsetMap = Charset.availableCharsets();
        for (String name :
                charsetMap.keySet()) {
            System.out.println(name);

        }

        //encode
        String str = "abcd阳阳";
        ByteBuffer byteBuffer = charset.encode(str);
        byte[] bytes = byteBuffer.array();
        for (byte b :
                bytes) {
            System.out.println(b);
        }

        //decode

        byte[] newBytes = bytes;
        ByteBuffer bbuf = ByteBuffer.wrap(newBytes);
        CharBuffer charBuffer = charset.decode(bbuf);
        String str2 = charBuffer.toString();
        System.out.println(str2);

    }
}
