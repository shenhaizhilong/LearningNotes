package JavaIO;

import java.io.File;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/31 10:19
 */
public class Delete {

    public static void recursiveDelete(File file)
    {
        // no file exists
        if(file == null ||  !file.exists())return;

        // recursive delete all the file in this directory
        if(file.isDirectory())
        {
            for(File f: file.listFiles())
            {
                recursiveDelete(f);
            }
        }
        // delete this file
        file.delete();
        System.out.println("delete file: " + file.getAbsolutePath());
    }

    public static void main(String[] args) {
        recursiveDelete(new File("D:\\test"));
    }
}
