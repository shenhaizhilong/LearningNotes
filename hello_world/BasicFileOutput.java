package hello_world;
import java.io.*;
/**
 * Created by shenhaizhilong on 4/29/2017.
 */
public class BasicFileOutput
{
    static String file = ".\\src\\hello_world\\Coffee.java";
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new StringReader(BufferedInputFile.read(".\\src\\hello_world\\Coffee.java")));
        PrintWriter out = new PrintWriter("coffee.txt");
        int lineCount =1;
        String s;
        while ((s=bufferedReader.readLine())!=null)
        {
            out.println(lineCount++ + ":" + s);
        }
        out.close();
        bufferedReader.close();
        System.out.println(BufferedInputFile.read("coffee.txt"));

    }
}
