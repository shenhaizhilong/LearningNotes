package JavaNetWorking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class CallbackDigest extends Thread {
    private File file;
    private byte[] digest;

    public CallbackDigest(File file)
    {
        this.file = file;
    }

    @Override
    public void run() {

        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            try(FileInputStream inputStream = new FileInputStream(file);
                DigestInputStream digestInputStream = new DigestInputStream(inputStream, messageDigest))
            {
                while (digestInputStream.read() != -1);
                digest =  messageDigest.digest();
                CallbackDigestUserInterface.receiveDigest(digest, file.toString());

            }
        }catch (NoSuchAlgorithmException ex)
        {
            System.out.println(ex.getMessage());
        }catch (NoSuchFileException ex)
        {
            System.out.println(ex.getMessage());
        }catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

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
        for (File f :
                fileList) {
            CallbackDigest cb = new CallbackDigest(f);
            cb.start();
        }

        System.out.println("Finished !");


    }
}
