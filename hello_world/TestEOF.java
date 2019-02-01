package hello_world;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by shenhaizhilong on 4/29/2017.
 */
public class TestEOF
{
    public static void main(String[] args) throws IOException
    {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(".\\src\\hello_world\\Coffee.java")));
        while (dataInputStream.available()!=0)
        {
            System.out.print((char) dataInputStream.readByte());
        }
    }
}
