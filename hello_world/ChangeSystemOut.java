package hello_world;

import java.io.PrintWriter;

/**
 * Created by shenhaizhilong on 4/29/2017.
 */
public class ChangeSystemOut
{
    public static void main(String[] args)
    {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("longlong");
    }
}
