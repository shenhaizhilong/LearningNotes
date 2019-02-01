package hello_world;

import java.io.*;

/**
 * Created by shenhaizhilong on 4/29/2017.
 */
public class Redirecting
{
    public static void main(String[] args) throws IOException
    {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(".\\src\\hello_world\\TextFile.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream( new FileOutputStream("test10.txt")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine())!=null)
        {
            System.out.println(s);
        }
        out.close();
        System.setOut(console);
    }
}
