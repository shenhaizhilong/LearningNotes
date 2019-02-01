package ThreadTest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


public class PipeRun {
    public static void main(String[] args) {


        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();
            outputStream.connect(inputStream);
            ThreadRead threadRead = new ThreadRead(readData, inputStream);
            threadRead.start();
            Thread.sleep(200);
            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();
        } catch (IOException e)
        {
            e.printStackTrace();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
