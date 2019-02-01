package ThreadTest;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
    public void readMethod(PipedInputStream inputStream)
    {
        try
        {
            System.out.println("Read:");
            byte[] bytes = new byte[4];
            int readLength = inputStream.read(bytes);
            System.out.println(readLength);
            while (readLength!=-1)
            {
                String newData = new String(bytes,0, readLength);

                System.out.print(newData);
                System.out.println("****");
                readLength = inputStream.read(bytes);
            }
            System.out.println();
            inputStream.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
