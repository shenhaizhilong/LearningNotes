package JavaNetWorking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class ChargenClient {
    public static int PORT = 19;

    public static void main(String[] args) throws InterruptedException {

        while (true)
        {
            try{
                SocketAddress address = new InetSocketAddress("127.0.0.1", PORT);
                SocketChannel client = SocketChannel.open(address);
                ByteBuffer buffer = ByteBuffer.allocate(74);
                WritableByteChannel out = Channels.newChannel(System.out);
                while (client.read(buffer) != -1)
                {
                    buffer.flip();
                    out.write(buffer);
                    buffer.clear();
                }


            }catch (IOException ex)
            {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }

            Thread.sleep(1000);
        }


    }
}
