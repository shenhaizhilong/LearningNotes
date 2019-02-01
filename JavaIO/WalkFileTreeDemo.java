package JavaIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeDemo {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("D:\\java_project\\Test");
       Files.walkFileTree(dir, new SimpleFileVisitor<Path>()
       {
           @Override
           public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
               System.out.println(path);
               return FileVisitResult.CONTINUE;
           }
           @Override
           public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) throws IOException {
               System.out.println(path +" 目录");
                if(!path.equals(dir))
                {
                    return FileVisitResult.SKIP_SUBTREE;
                }
               return FileVisitResult.CONTINUE;
           }




           @Override
           public FileVisitResult visitFileFailed(Path path, IOException exc) throws IOException {
               System.out.println(path);
               return FileVisitResult.CONTINUE;
           }
       });
    }
}
