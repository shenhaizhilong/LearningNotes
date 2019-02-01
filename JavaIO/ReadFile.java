package JavaIO;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/1 15:48
 */
public class ReadFile {

    public static void readByFileReader(String fileName) throws  IOException
    {
        System.out.println("Read By File Reader:");
        File file  = new File(fileName);
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                // handle this line
                System.out.println(line);
            }
        }
    }

   public static void readByBufferedReader(String fileName, Charset charset) throws IOException
   {
       File file = new File(fileName);
       System.out.println("Read file By Buffered Reader: ");
       try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)))
       {
           String line = null;
           while ((line = reader.readLine()) != null)
           {
               // handle this line
               System.out.println(line);
           }
       }
   }

   public static void readByBufferedReaderJava7(String fileName, Charset charset) throws IOException
   {

       System.out.println("Read file By Buffered Reader in Java 7: ");
       Path path = Paths.get(fileName);
       try(BufferedReader reader = Files.newBufferedReader(path, charset))
       {
           String line = null;
           while ((line = reader.readLine()) != null)
           {
               // handle this line
               System.out.println(line);
           }
       }
   }

   public static void readByScanner(String fileName, String charsetName) throws IOException
   {
       System.out.println("Read file By Scanner: ");
       Path path = Paths.get(fileName);
       try(Scanner scanner = new Scanner(path, charsetName))
       {
           String line = null;
           while (scanner.hasNextLine())
           {
               line = scanner.nextLine();
               // handle this line;
               System.out.println(line);
           }
       }
   }

   public static void readByFiles(String fileName) throws IOException
   {
       Path path = Paths.get(fileName);
       List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
       System.out.println(allLines);

   }

   public static void readByApacheCommons(String fileName) throws IOException
   {
       List<String> allLines = FileUtils.readLines(new File(fileName), StandardCharsets.UTF_8);
       System.out.println(allLines);
   }


    public static void main(String[] args) throws IOException {
        readByApacheCommons("text.txt");
    }
}
