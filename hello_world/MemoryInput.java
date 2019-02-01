package hello_world;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by shenhaizhilong on 4/29/2017.
 */
public class MemoryInput
{
    public static void main(String[] args) throws IOException
    {
        StringReader stringReader = new StringReader(BufferedInputFile.read(".\\src\\hello_world\\Coffee.java"));
        int c;
        while ((c=stringReader.read())!=-1)
        {
            System.out.print((char) c);
        }
    }
}
