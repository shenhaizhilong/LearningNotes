package JavaIO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesDemo {
    public static void main(String[] args) throws IOException {

        Charset charset = Charset.forName("utf-8");
        Path path = Paths.get("D:\\java_project\\Test\\file.txt");
        InputStream in = Files.newInputStream(path);
        OutputStream out = Files.newOutputStream(path);
        Reader reader = Files.newBufferedReader(path, charset);
        Writer writer = Files.newBufferedWriter(path, charset);


    }
}
