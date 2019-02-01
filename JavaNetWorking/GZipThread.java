package JavaNetWorking;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GZipThread {

    public static final int THREAD_COUNT = 4;
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:\\java_project\\Test");
        List<File> fileList = new ArrayList<>();


        SimpleFileVisitor<Path> simpleFileVisitor = new SimpleFileVisitor<Path>()
        {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                String filename = file.toString();
                if(filename.endsWith(".txt") || file.endsWith(".xml"))
                {
                    fileList.add(file.toFile());
                }
                return FileVisitResult.CONTINUE;
            }
        };

        Files.walkFileTree(path, simpleFileVisitor);
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
        String savePath = "D:\\java_project\\gzipdemo\\";
        for (File f :
                fileList) {
            Runnable runnable = new GZipRunnable(f, savePath);
            pool.submit(runnable);
        }

        pool.shutdown();



    }
}
