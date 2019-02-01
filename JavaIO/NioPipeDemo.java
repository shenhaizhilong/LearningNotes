package JavaIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class NioPipeDemo {
    public static void main(String[] args) throws IOException {

        //writing to a pipe
        Pipe pipe =  Pipe.open();
        Pipe.SinkChannel sinkChannel = pipe.sink();
        String newData = "new data" + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.put(newData.getBytes());
        buf.flip();
        while (buf.hasRemaining())
        {
            sinkChannel.write(buf);
        }


        //reading from a pipe
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = sourceChannel.read(buffer);

        System.out.println(bytesRead);
        System.out.println(buffer.toString());
        buffer.flip();
        while (buffer.hasRemaining())
        {
            System.out.print((char)buffer.get());
        }


    }
}
