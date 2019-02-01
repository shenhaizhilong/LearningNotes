package hello_world;
import java.util.regex.*;
import java.io.*;
import java.util.*;
/**
 * Created by shenhaizhilong on 4/28/2017.
 */
public class DirList
{
    public static void main(String[] args)
    {
        File path = new File(".");
        String[] fileList;
        if(args.length==0)
        {
            fileList = path.list(new DirFilter("D.*.java"));
        }
        else {
            fileList = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(fileList);
        for(String dirItem: fileList)
        {
            System.out.println(dirItem);
        }
    }

}

class DirFilter implements FilenameFilter
{
    private Pattern pattern;
    public DirFilter(String regex)
    {
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name)
    {
        return pattern.matcher(name).matches();
    }
}