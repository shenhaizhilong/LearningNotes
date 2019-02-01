package JavaIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelDemo {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:\\test\\test.txt");

        if(!path.toFile().exists())
            Files.createFile(path);

        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.APPEND);
        byte[] bytes = new byte[124];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)i;
        }

        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        while (byteBuffer.hasRemaining())
        {
            byte b = byteBuffer.get();
            System.out.print((char)b);
        }

        //
        byteBuffer = ByteBuffer.wrap(bytes);

        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        System.out.println("CharBuffer ");
        System.out.println(charBuffer.toString());
        System.out.println("default byteOrder " + byteBuffer.order());
        System.out.println("nativeOrder " + ByteOrder.nativeOrder());
        byteBuffer = byteBuffer.order(ByteOrder.nativeOrder());
        System.out.println("change it to nativeOrder " + byteBuffer.order());

        for (int i = 0; i < byteBuffer.limit(); i++) {
            byte b = byteBuffer.get(i);
            System.out.print((char)b);
        }


        fileChannel.write(byteBuffer);
        String str = "Hello, World!";
        bytes = str.getBytes(Charset.forName("utf-8"));
        byteBuffer = ByteBuffer.wrap(bytes);
        fileChannel.write(byteBuffer);

        fileChannel.close();

        //遍历


    }
}
