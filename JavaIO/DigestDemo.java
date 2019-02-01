package JavaIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String algname = args.length >=2 ? args[1] : "SHA-1";
        MessageDigest alg = MessageDigest.getInstance(algname);
        byte[] input = Files.readAllBytes(Paths.get(args[0]));
        byte[] hash = alg.digest(input);
        String d = "";
        for (int i = 0; i < hash.length; i++) {
            int v = hash[i] & 0xff;
            if(v<16) d+="0";
            d+=Integer.toHexString(v).toLowerCase();
        }

        System.out.println(d);

    }
}
