package Fundament;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;

public class ExceptionDemo {
    public static void main(String[] args) {

    }
    public void read(String fileName)
    {
        InputStream inputStream=null;
        try
        {
            try{
                inputStream= new FileInputStream(fileName);
                int b;
                while ((b=inputStream.read()) !=-1)
                {


                }
            }catch (FileNotFoundException | UnknownHostException e)
            {
                System.out.println(e.getMessage());
                //can't assign a value to the final variable e
                //e = new FileNotFoundException("e");
            }catch (IOException e)
            {
                System.out.println(e.getMessage());

            }finally {
                inputStream.close();
            }
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
