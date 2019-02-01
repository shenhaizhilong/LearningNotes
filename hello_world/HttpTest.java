package hello_world;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by shenhaizhilong on 6/2/2017.
 */
public class HttpTest
{
    public static void main(String[] args) throws Exception
    {
        URL url = new URL("https://github.com/hdinsight/hdinsight.github.io/tree/master/hbase");

        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        // get the input stream for from that connection
        InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnection.getInputStream());
        int respInt = inputStreamReader.read();
        while (respInt!=-1)
        {
            System.out.print((char) respInt);
            respInt = inputStreamReader.read();
        }
    }
}
