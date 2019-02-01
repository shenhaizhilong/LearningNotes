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

public class ReturnDigest extends Thread {
    private byte[] digests;
    private File file;

    public ReturnDigest(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        System.out.println("Hello " + Thread.currentThread().toString());
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            try(FileInputStream fileInputStream = new FileInputStream(file))
            {
                try(DigestInputStream digestInputStream = new DigestInputStream(fileInputStream, messageDigest))
                {
                    while (digestInputStream.read()!= -1);
                    digests = messageDigest.digest();
                }


            }
        }catch (FileNotFoundException e)
        {
            System.err.println(e.getMessage());
        }catch (NoSuchAlgorithmException e)
        {
            System.err.println(e.getMessage());
        }catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public byte[] getDigests() {
        return digests;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

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
            System.out.println(f.toString());
        }

        ReturnDigest[] digests = new ReturnDigest[fileList.size()];
        for (int i = 0; i < fileList.size(); i++) {
            digests[i] = new ReturnDigest(fileList.get(i));
            digests[i].start();
        }
        System.out.println("Started all Threads");

        for (int i = 0; i < fileList.size(); i++) {
            digests[i].join();
        }


//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread());
//        //Thread.sleep(1000*3);
//        for (int i = 0; i < fileList.size(); i++) {
//            String results = fileList.get(i).toString() + " :";
//            while (true)
//            {
//                System.out.println(digests[i].toString() + " " + results);
//                byte[] digest = digests[i].getDigests();
//                if(digest !=null)
//                {
//                    results += DatatypeConverter.printHexBinary(digest);
//                    System.out.println(results);
//                    break;
//                }
//
//            }
//
//        }

        for (int i = 0; i < fileList.size(); i++) {
            String filename = fileList.get(i).toString() + " : ";
            byte[] digest = digests[i].getDigests();
            String res = filename;
            if(digest !=null)
            {
                res += DatatypeConverter.printHexBinary(digest);
                System.out.println(res);
            }
        }
        System.out.println("Finished!");
    }
}
