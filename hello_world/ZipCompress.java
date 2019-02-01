package hello_world;

import java.io.*;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.*;

/**
 * Created by shenhaizhilong on 4/30/2017.
 */
public class ZipCompress
{
    public static void main(String[] args) throws IOException
    {
        String[] args1 = {"coffee.txt", "pom.xml"};
        FileOutputStream f = new FileOutputStream("Test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        for(String arg:args1)
        {
            System.out.println("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            String line = null;
            while ((line = in.readLine())!=null)
            {
                out.write(line.getBytes());
                out.write(System.getProperty("line.separator").getBytes());
            }
            in.close();
            out.flush();
        }
        out.close();
        System.out.println("Checksum: " + csum.getChecksum().getValue());
        //now extract the files;
        FileInputStream fi = new FileInputStream("Test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        ZipEntry ze;
        while ((ze = in2.getNextEntry())!=null)
        {
            System.out.println("****************");
            System.out.println(ze.getName());
            System.out.println("****************");
            Scanner scanner = new Scanner(in2);
            while (scanner.hasNextLine())
            {
                System.out.println(scanner.nextLine());
            }
            in2.closeEntry();

        }
        if(args1.length>0)
            System.out.println("Checksum: " + csumi.getChecksum().getValue());


    }
}
