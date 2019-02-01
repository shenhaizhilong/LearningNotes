package JavaIO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest alg = MessageDigest.getInstance("md5");
        String message = "hello, I am tom";
        alg.update(message.getBytes());
        byte[] hash = alg.digest();
        String d = "";
        for (int i = 0; i < hash.length; i++) {
            int v = hash[i] & 0xff;
            if(v<16) d+="0";
            d+= Integer.toHexString(v).toLowerCase();
        }

        System.out.println(d);

    }
}
