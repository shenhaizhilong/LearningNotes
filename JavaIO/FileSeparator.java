package JavaIO;

import java.io.File;

/**
 * @author: shenhaizhilong
 * @date: 2019/1/31 16:52
 */
public class FileSeparator {
    public static void main(String[] args) {
        System.out.println("File.separator = " + File.separator);
        System.out.println("File.separatorChar = " + File.separatorChar);
        System.out.println("File.pathSeparator = " + File.pathSeparator);
        System.out.println("File.pathSeparatorChar = " + File.pathSeparatorChar);

        //platform independent and safe to use across Unix and Windows
        File fileSafe = new File("tmp"+File.separator+"abc.txt");
    }
}
