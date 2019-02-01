package JavaNetWorking;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class InstanceCallbackDigest implements Runnable {

    private String filename;
    private InstanceCallbackDigestUserInterface callback;

    public InstanceCallbackDigest(String filename, InstanceCallbackDigestUserInterface callback)
    {
        this.filename = filename;
        this.callback = callback;
    }

    @Override
    public void run() {

        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            try(FileInputStream inputStream = new FileInputStream(filename); DigestInputStream din = new DigestInputStream(inputStream, messageDigest))
            {
                while (din.read() != -1);
                byte[] digest = messageDigest.digest();
                callback.receiveDigest(digest);

            }
        }catch (IOException | NoSuchAlgorithmException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}
