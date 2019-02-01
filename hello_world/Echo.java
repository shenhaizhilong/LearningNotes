package hello_world;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shenhaizhilong on 4/29/2017.
 */
public class Echo
{
    //how to read from the standard input.
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=bufferedReader.readLine())!=null && s.length()>0)
        {
            System.out.println(s);
        }
    }

}
