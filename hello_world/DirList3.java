package hello_world;
import java.util.*;
import java.io.*;
import java.util.regex.*;
/**
 * Created by shenhaizhilong on 4/28/2017.
 */
public class DirList3
{
    public static void main(String[] args)
    {
        File path = new File(".");
        String[] list;
        if(args.length==0)
        {
            list = path.list();
        }
        else {
            System.out.println("here");
            System.out.println(args[0]);
            list = path.list(new FilenameFilter() {
                private Pattern pattern= Pattern.compile(args[0]);

                @Override
                public boolean accept(File dir, String name)
                {
                    return pattern.matcher(name).matches();
                }
            });

        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem: list)
        {
            System.out.println(dirItem);
        }
    }
}
