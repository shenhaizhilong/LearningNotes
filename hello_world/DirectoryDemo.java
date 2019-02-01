package hello_world;
import java.io.*;

/**
 * Created by shenhaizhilong on 4/28/2017.
 */
public class DirectoryDemo
{
    public static void main(String[] args)
    {
        PPrint.pprint(Directory.walk(".").dirs);
        for(File file:Directory.local(".", "T.*"))
        {
            System.out.println(file);
        }
        System.out.println("-------------------------");
        for(File file: Directory.walk(".", "T.*\\.java"))
        {
            System.out.println(file);
        }
        for(File file: Directory.walk(".", ".*[Zz].*\\.class"))
        {
            System.out.println(file);
        }
    }
}
