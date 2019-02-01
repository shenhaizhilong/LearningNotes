package JavaNetWorking;

import java.io.IOException;
import java.net.ServerSocket;

public class LocalPortScanner {

    public static void main(String[] args) {

        for (int i = 0; i < 65535; i++) {
            try
            {
                ServerSocket serverSocket = new ServerSocket(i);
            }catch (IOException ex)
            {
                System.out.println("Post:" + i + " is used");
            }
        }
    }
}
