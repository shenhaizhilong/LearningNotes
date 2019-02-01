package JavaIO;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PathDemo {
    public static void main(String[] args) throws IOException {
        Path absolute = Paths.get("D:\\java_project\\Test\\file.txt");
        File file = absolute.toFile();
        if(file.exists())
        {
            file.delete();

        }
        file.createNewFile();
        System.out.println(absolute);
        System.out.println(absolute.getParent());
        System.out.println(absolute.getRoot());

        String content = "zhang:x:1000:1000:,,,:/home/zhang:/bin/bash灰灰";
        Charset charset = Charset.forName("utf-8");
        Files.write(absolute, content.getBytes(charset), StandardOpenOption.APPEND);

        byte[] bytes = Files.readAllBytes(absolute);
        content = new String(bytes, charset);
        System.out.println(content);
        List<String> list = Files.readAllLines(absolute, charset);
        System.out.println(list);
        Files.write(absolute, list, StandardOpenOption.APPEND);


    }
}
