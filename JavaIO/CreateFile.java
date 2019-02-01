package JavaIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/31 16:11
 */
public class CreateFile {

    public static void main(String[] args) throws IOException {
        // use system property file.separator to make our program cross-platform.
        String fileSep = System.getProperty("file.separator");
        method1("text1.txt", "1,2,3,4,5");   // writer
        method2("text2.txt", "1,2,3,4,5");   // output stream
        method3("text3.txt", "6,7,8,9,10");  // nio

    }

    public  static void method1(String filename, String data)
    {
        File file = new File(filename);

        try
        {
            if(!file.exists())
            {
                boolean hasSuccess = file.createNewFile();
                if(hasSuccess)
                {
                    System.out.println("Created file: " + filename);
                }else {
                    System.out.println("File already exists: " + filename);
                }
            }

            try(Writer writer = new FileWriter(file))
            {
                writer.write(data);
                writer.flush();
            }


        }catch (IOException ex)
        {
            ex.printStackTrace();
        }




    }

    public static void method2(String filename, String data) throws IOException
    {
        try(FileOutputStream outputStream = new FileOutputStream(filename))
        {
            outputStream.write(data.getBytes());
            outputStream.flush();  // flush the data to file
        }

    }

    public static void method3(String filename, String data) throws IOException
    {
        Files.write(Paths.get(filename), data.getBytes());
    }
}
