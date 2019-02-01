package JavaIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioLockDemo {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:\\test\\test.txt");

        if(!path.toFile().exists())
            Files.createFile(path);

        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.WRITE);

        try(FileLock lock = fileChannel.lock())
        {
            String str = "Hello, World!";
            ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
            fileChannel.write(byteBuffer);

            lock.release();
            lock.close();

        }
        fileChannel.close();
//        FileLock lock1 = fileChannel.tryLock();

    }
}
