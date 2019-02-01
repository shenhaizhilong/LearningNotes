package ThreadTest;

import java.io.IOException;
import java.io.PipedOutputStream;


public class WriteData {
    public void writeMethod(PipedOutputStream outputStream)
    {
        try
        {
            System.out.println("Write:");
            for (int i = 1024; i < 103400; i++) {
                String outData = ""+(i+1);
                outputStream.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            outputStream.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
