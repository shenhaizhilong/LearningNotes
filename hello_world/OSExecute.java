package hello_world;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by shenhaizhilong on 4/29/2017.
 */
public class OSExecute
{
    public static void command(String cmd)
    {
        boolean err = false;
        try
        {
            Process process = new ProcessBuilder(cmd.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine())!=null)
            {
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine())!=null)
            {
                System.err.println(s);
                err = true;
            }
        }catch (Exception e)
        {
            if(!cmd.startsWith("CMD /C"))
            {
                command("CMD /C " + cmd);
            }
            else {
                throw new RuntimeException(e);
            }
        }
        if(err)
        {
            throw new OsExecuteException("Errors Executing " + cmd);
        }
    }
}
