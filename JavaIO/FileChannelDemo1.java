package JavaIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        try (RandomAccessFile accessFile = new RandomAccessFile("D:\\java_project\\Test\\src\\nio-data.txt", "rw")) {

            FileChannel inChannel = accessFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf);
            System.out.println(bytesRead);
            while (bytesRead !=-1)
            {
                System.out.println("Read " + bytesRead);
                buf.flip();
                while (buf.hasRemaining())
                {
                    System.out.println((char)buf.get());
                }

                buf.clear();
                bytesRead = inChannel.read(buf);
            }
        }
    }
}
