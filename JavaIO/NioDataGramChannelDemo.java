package JavaIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class NioDataGramChannelDemo {
    public static void main(String[] args) throws IOException {

        DatagramChannel datagramChannel = DatagramChannel.open();
        String data = "New String to write to file ...." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(data.getBytes());
        buf.flip();
        int bytesSend = datagramChannel.send(buf, new InetSocketAddress("baidu.com", 80));
        System.out.println(bytesSend);

    }
}
