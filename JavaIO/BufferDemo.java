package JavaIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferDemo {
    public static void main(String[] args) throws IOException {


        Path path = Paths.get("D:\\test\\test.txt");

        if(!path.toFile().exists())
            Files.createFile(path);

        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.WRITE);

        String str = "Hello, World!ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(str.length());

        ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes());
        fileChannel.write(byteBuffer);


        fileChannel = FileChannel.open(path, StandardOpenOption.READ);
        byteBuffer = ByteBuffer.allocate(400);
        fileChannel.read(byteBuffer);

        // if we use flip method, then confine = position, position =0;
        //byteBuffer.flip();

        //confine doesn't change, position = 0.
        byteBuffer.rewind();


        //remaining = confine - position

        while (byteBuffer.hasRemaining())
        {
            System.out.println("current position:" + byteBuffer.position());
            System.out.println("remaining:" + byteBuffer.remaining());
            System.out.println("byte buffer capacity:" + byteBuffer.capacity());
            char c = (char)byteBuffer.get();
            System.out.println(c);
        }

        fileChannel.close();

    }
}
