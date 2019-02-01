package JavaNetWorking;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class DigestRunnable implements Runnable {

    private File file;

    public DigestRunnable(File file)
    {
        this.file = file;
    }
    @Override
    public void run() {

        try
        {
            try(FileInputStream fileInputStream = new FileInputStream(file))
            {
                MessageDigest sha = MessageDigest.getInstance("SHA-256");
                try(DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, sha))
                {
                    while (digestInputStream.read()!=-1);
                    byte[] myDigestBytes = sha.digest();
                    String results = file.toString() + ":";
                    results += DatatypeConverter.printHexBinary(myDigestBytes);
                    System.out.println(results);
                }
            }



        }catch (FileNotFoundException e)
        {
            System.err.println(e);
        }catch (NoSuchAlgorithmException ex)
        {
            System.err.println(ex);
        }
        catch (IOException ex)
        {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) throws IOException {

        Path directory = Paths.get("D:\\java_project\\Test");
        List<File> fileList = new ArrayList<>();
        SimpleFileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>()
        {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {

                String filename = path.toString();
                if(filename.endsWith(".txt") || filename.endsWith(".xml"))
                {
                    fileList.add(path.toFile());
                }
                return FileVisitResult.CONTINUE;
            }
        };

        Files.walkFileTree(directory, fileVisitor);
        for (File f :
                fileList) {
            Thread t = new Thread((new DigestRunnable(f)));
            t.start();
        }

    }
}
