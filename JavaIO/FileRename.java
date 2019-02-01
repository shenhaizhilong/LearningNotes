package JavaIO;

import java.io.File;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/31 16:59
 *
 * rename a file or move a file
 */
public class FileRename {

    public static void main(String[] args) {

        File source = new File("text1.txt");
        File target = new File("text11.md");
        if(source.renameTo(target))
        {
            System.out.println("rename succeed");
        }else {
            System.out.println("rename failed");
        }

        source = new File("text11.md");
        target = new File("D:/text11.md");
        if(source.renameTo(target))
        {
            System.out.println("rename succeed");
        }else {
            System.out.println("rename failed");
        }

    }
}
