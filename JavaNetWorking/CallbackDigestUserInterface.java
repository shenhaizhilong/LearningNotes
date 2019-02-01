package JavaNetWorking;

import javax.xml.bind.DatatypeConverter;

public class CallbackDigestUserInterface {

    public static void receiveDigest(byte[] digest, String filename)
    {
        System.out.println(filename + " : " + DatatypeConverter.printHexBinary(digest));
    }
}
