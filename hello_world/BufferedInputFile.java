package hello_world;
import java.io.*;
/**
 * Created by shenhaizhilong on 4/29/2017.
 */
public class BufferedInputFile
{
    public static String read(String fileName) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s=in.readLine())!=null)
        {
            sb.append(s+"\n");
        }
        in.close();
        return sb.toString();
    }
    public static void main(String[] args) throws IOException
    {
        System.out.println(read(".\\src\\hello_world\\Coffee.java"));
        
    }

}
