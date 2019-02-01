package JavaIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelTransferFrom {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        try (RandomAccessFile fromFile = new RandomAccessFile("D:\\java_project\\Test\\src\\nio-data.txt", "rw");
             RandomAccessFile toFile = new RandomAccessFile("D:\\java_project\\Test\\src\\nio-data-out.txt", "rw")) {


            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();
            long position = 0;
            long count = fromChannel.size();
            System.out.println("Input File Size:" + count);
            toChannel.transferFrom(fromChannel, position, count);

        }

        try (RandomAccessFile fromFile = new RandomAccessFile("D:\\java_project\\Test\\src\\nio-data.txt", "rw");
             RandomAccessFile toFile = new RandomAccessFile("D:\\java_project\\Test\\src\\nio-data-out2.txt", "rw")) {

            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();
            long position = 0;
            long count = fromChannel.size();
            System.out.println("Input File Size:" + count);
            fromChannel.transferTo(position, count, toChannel);

        }


        System.out.println("Transfer Done!");
    }
}
