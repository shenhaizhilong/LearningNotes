package JavaIO;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/1 13:29
 */
public class GetFileSize {


    // by File instance
    // The length, in bytes, of the file denoted by this abstract pathname, or <code>0L</code> if the file does not exist.
    public static long getFileSize(File file)
    {
        return file.length();
    }

    // by channel instance
    public static long getFileSize(Path path)
    {
        long fileSize = 0L;
        try{
            FileChannel channel = FileChannel.open(path);
            fileSize = channel.size();
            channel.close();
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return fileSize;
    }

    public static long getFileSize(String fileName)
    {
        File file = new File(fileName);
        return FileUtils.sizeOf(file);
    }


    public static void main(String[] args) {

        System.out.println(getFileSize(new File("text.txt")));
        System.out.println(getFileSize(Paths.get("text.txt")));
        System.out.println(getFileSize("text.txt"));
    }
}
