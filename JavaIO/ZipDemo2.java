package JavaIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ZipDemo2 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\java_project\\Test\\testa.zip");

        FileSystem fs = FileSystems.newFileSystem(path, null);
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        });

        Path path1 = fs.getPath("pom.xml");
        Files.copy(path1, Paths.get("D:\\test\\" + path1.getFileName() ), StandardCopyOption.REPLACE_EXISTING);

    }

}
