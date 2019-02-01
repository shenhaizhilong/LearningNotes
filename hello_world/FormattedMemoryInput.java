package hello_world;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by shenhaizhilong on 4/29/2017.
 */
public class FormattedMemoryInput
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read(".\\src\\hello_world\\Coffee.java").getBytes()));
            while (true)
            {
                System.out.print((char)dataInputStream.readByte());
            }
        }catch (EOFException e)
        {
            System.err.println("End of Stream");
        }

    }
}
