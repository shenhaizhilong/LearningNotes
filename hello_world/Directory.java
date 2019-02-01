package hello_world;
import java.util.regex.*;
import java.io.*;
import java.util.*;
/**
 * Created by shenhaizhilong on 4/28/2017.
 */
public final class Directory
{
    public static File[] local(File dir, final String regex)
    {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern =  Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name)
            {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });

    }
    public static File[] local(String path, final String regex)
    {
        //Overloaded
        return local(new File(path), regex);
    }
    public static class TreeInfo implements Iterable<File>
    {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        public Iterator<File> iterator()
        {
            return files.iterator();
        }
        void addAll(TreeInfo other)
        {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }
        public String toString()
        {
            return "dirs: " + PPrint.pformat(dirs)+ "\n\nfiles: " + PPrint.pformat(files);

        }
    }
    static TreeInfo recusreDirs(File startDir, String regex)
    {
        TreeInfo results = new TreeInfo();
        for(File item : startDir.listFiles())
        {
            if(item.isDirectory())
            {
                results.dirs.add(item);
                results.addAll(recusreDirs(item, regex));
            }else {
                if(item.getName().matches(regex))
                {
                    results.files.add(item);
                }
            }
        }
        return results;
    }
    public static TreeInfo walk(String start, String regex)
    {
        // Begin recursion
        return recusreDirs(new File(start), regex);
    }
    public static TreeInfo walk(File start, String regex)
    {
        return recusreDirs(start, regex);
    }
    public static TreeInfo walk(File start)
    {
        //Everything
        return recusreDirs(start, ".*");
    }
    public static TreeInfo walk(String start)
    {
        return recusreDirs(new File(start), ".*");
    }
    public static void main(String[] args)
    {
        if(args.length==0)
        {
            System.out.println(walk("."));
           // System.out.println(walk("E:\\", ".*java"));
        }
        else{
            for(String arg:args)
            {
                System.out.println(walk(arg));
            }
        }
    }

}
