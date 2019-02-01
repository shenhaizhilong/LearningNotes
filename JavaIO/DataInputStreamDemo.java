package JavaIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class DataInputStreamDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("D:\\迅雷下载\\54babf71643");
        File outPutFile = new File("D:\\迅雷下载\\54babf7164322.ts");
        Path path = file.toPath();
        final List<File> files = new ArrayList<>();
        SimpleFileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException
            {
                files.add(filePath.toFile());
                return  FileVisitResult.CONTINUE;
            }
        };

        Files.walkFileTree(path, fileVisitor);

        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outPutFile)) );
        DataInputStream inputStream = null;
        for (File f :
                files) {
            inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));

            int byteAvailable = inputStream.available();
            if (byteAvailable>0)
            {
                byte[] data = new byte[byteAvailable];
                inputStream.read(data);
                outputStream.write(data);
            }

        }
        outputStream.flush();
        if(inputStream !=null)
        {
            inputStream.close();
        }
        if(outputStream !=null)
        {
            outputStream.close();
        }

    }



}
