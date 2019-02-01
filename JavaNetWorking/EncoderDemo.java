package JavaNetWorking;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncoderDemo {
    public static void main(String[] args) {

        try
        {
            System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
            System.out.println(URLEncoder.encode("This*string*has*", "UTF-8"));
            System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
            System.out.println(URLEncoder.encode("This+string+has+plus", "UTF-8"));

        }catch (UnsupportedEncodingException ex)
        {
            ex.printStackTrace();
        }

    }
}
