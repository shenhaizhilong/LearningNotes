package JavaIO;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;

public class AESDemo {
    public static void main(String[] args) throws IOException, GeneralSecurityException, ClassNotFoundException {

        if(args[0].equalsIgnoreCase("-genkey"))
        {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            keygen.init(secureRandom);
            SecretKey key = keygen.generateKey();
            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(args[1])))
            {
                out.writeObject(key);
            }
        }else {
            int mode;
            if(args[0].equalsIgnoreCase("-encrypt")) mode = Cipher.ENCRYPT_MODE;
            else if(args[0].equalsIgnoreCase("-decrypt")) mode = Cipher.DECRYPT_MODE;
            else{
                System.out.println("Error parameter!");
                return;
            }

            try(ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[3]));
            InputStream in = new FileInputStream(args[1]);
            OutputStream out = new FileOutputStream(args[2]))
            {
                Key key = (Key)keyIn.readObject();
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(mode, key);
                Util.crypt(in, out, cipher);
            }
        }

    }
}
