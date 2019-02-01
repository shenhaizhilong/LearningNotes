package JavaIO;


import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipDemo {
    public static void main(String[] args) throws IOException {
        String[] filenames = {"out.txt", "coffee.txt", "pom.xml"};

        //zip all the files to a zip file.
        String zipFilename = "testa.zip";
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilename)))
        {
            for (String filename :
                    filenames) {
                ZipEntry zipEntry = new ZipEntry(filename);
                zipOutputStream.putNextEntry(zipEntry);
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename)))
                {
                    String line = null;
                    while ((line = bufferedReader.readLine())!=null)
                    {
                        zipOutputStream.write(line.getBytes(Charset.forName("utf-8")));
                        zipOutputStream.write(System.getProperty("line.separator").getBytes());
                    }
                }

                zipOutputStream.closeEntry();
            }
            zipOutputStream.close();
        }


        //
        try(ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilename)))
        {
            ZipEntry zipEntry = null;
            while ((zipEntry = zipInputStream.getNextEntry())!=null)
            {
                System.out.println("****************");
                System.out.println(zipEntry.getName());
                System.out.println("****************");
                Scanner scanner = new Scanner(zipInputStream);
                while (scanner.hasNextLine())
                {
                    System.out.println(scanner.nextLine());
                }
                zipInputStream.closeEntry();
            }

        }


    }
}
