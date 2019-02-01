package JavaIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class NioSelectorDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {

      try(SocketChannel socketChannel = SocketChannel.open())
      {
          socketChannel.configureBlocking(false);
          socketChannel.connect(new InetSocketAddress("http://jenkov.com",80));
          while (!socketChannel.finishConnect())
          {
              //wait, do sth else.
          }
      }
    }

}
