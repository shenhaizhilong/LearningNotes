package JavaIO;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author: shenhaizhilong
 * @date: 2019/2/1 13:50
 */
public class FileNameFilterDemo {

    public static void main(String[] args) {
        File file = new File("D:/demo");
        String ext = "txt";
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(ext);
            }
        });

        for(File f: files)
        {
            System.out.println(f.getAbsolutePath());
        }
        System.out.println("*******************");

         files = file.listFiles((d,s) -> s.toLowerCase().endsWith(ext) );
        for(File f: files)
        {
            System.out.println(f.getAbsolutePath());
        }

    }
}
