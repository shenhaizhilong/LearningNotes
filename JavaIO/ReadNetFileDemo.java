package JavaIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ReadNetFileDemo {
    public static void main(String[] args) {

        String fileUrl = "http://juzheng2018032725986.chinacloudsites.cn/test2.txt";


        try {
            URL url = new URL(fileUrl);
            URLConnection connection = url.openConnection();
            connection.connect();

            try(InputStream inputStream = connection.getInputStream())
            {
                Scanner scanner = new Scanner(inputStream);
                while (scanner.hasNextLine())
                {
                    System.out.println(scanner.nextLine());
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }


        }



}
