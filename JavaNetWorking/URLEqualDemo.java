package JavaNetWorking;

import java.net.MalformedURLException;
import java.net.URL;

public class URLEqualDemo {

    public static void main(String[] args) {

        try
        {
            URL www = new URL("http://www.azure.cn/");
            URL ibiblio = new URL("http://azure.cn/");
            if(www.equals(ibiblio))
            {
                System.out.println(ibiblio + " equals " + www);
            }else {
                System.out.println(ibiblio + " not equals " + www);
            }
        }catch (MalformedURLException ex)
        {
            ex.printStackTrace();
        }
    }
}
