package JavaNetWorking;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class InstanceCallbackDigestUserInterface {
    private String filename;
    private byte[] digest;
    public InstanceCallbackDigestUserInterface(String filename)
    {
        this.filename = filename;
    }

    public void calculateDigest()
    {
        InstanceCallbackDigest cb = new InstanceCallbackDigest(filename, this);
        Thread t = new Thread(cb);
        t.start();
    }

    public void receiveDigest(byte[] digest)
    {
        this.digest = digest;
        System.out.println(this);
    }

    @Override
    public String toString() {

        String results = filename + ":";
        if(digest !=null)
        {
            results += DatatypeConverter.printHexBinary(digest);
        }else {
            results += "digest not available";
        }
        return results;
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
            InstanceCallbackDigestUserInterface cb = new InstanceCallbackDigestUserInterface(f.toString());
            cb.calculateDigest();
        }
    }
}
