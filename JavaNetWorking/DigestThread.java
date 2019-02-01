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

public class DigestThread extends Thread {
    private File file;
    public DigestThread(File file)
    {
        this.file = file;
    }

    @Override
    public void run()
    {
        try{

            try(FileInputStream inputStream = new FileInputStream(file))
            {
                MessageDigest sha = MessageDigest.getInstance("SHA-256");
                DigestInputStream digestInputStream = new DigestInputStream(inputStream, sha);
                while (digestInputStream.read() !=-1);
                digestInputStream.close();
                byte[] digest = sha.digest();
                StringBuilder results = new StringBuilder(file.toString());
                results.append(":");
                results.append(DatatypeConverter.printHexBinary(digest));
                System.out.println(results.toString());
            }



        }catch (FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }catch (NoSuchAlgorithmException e){
            System.err.println(e.getMessage());
        }catch (IOException e)
        {
            System.err.println(e.getMessage());
        }

    }


    public static void main(String[] args) throws IOException {

        List<File> fileList = new ArrayList<>();
        SimpleFileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>()
        {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                String filename = file.toString();
                if(filename.endsWith("txt") || filename.endsWith("xml"))
                {
                    fileList.add(file.toFile());
                }
                return FileVisitResult.CONTINUE;
            }
        };

        Path path  = Paths.get("D:\\java_project\\Test");
        Files.walkFileTree(path , fileVisitor);
        DigestThread myDigest;
        for (File f :
                fileList) {
            myDigest = new DigestThread(f);
            myDigest.start();

        }

    }
}
