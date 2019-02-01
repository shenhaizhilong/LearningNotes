package hello_world;
import java.util.*;
import java.io.*;
import java.util.regex.*;
/**
 * Created by shenhaizhilong on 4/28/2017.
 */
public class DirList2
{
    public static FilenameFilter filter(final String regex)
    {
        // creation of anonymous inner class;
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name)
            {
                return pattern.matcher(name).matches();
            }
        };//end of anonymous inner class
    }
    public static void main(String[] args)
    {
        File path = new File(".");
        String[] list;
        if(args.length==0)
        {
            list= path.list();
        }
        else {
            list = path.list(filter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem: list)
        {
            System.out.println(dirItem);
        }

    }
}
