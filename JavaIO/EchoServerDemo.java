package JavaIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerDemo {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("Address is:" + address);
        try(ServerSocket serverSocket = new ServerSocket(9100, 100, address ))
        {
            try(Socket socket = serverSocket.accept())
            {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                try(Scanner scanner = new Scanner(inputStream))
                {
                    PrintWriter printWriter = new PrintWriter(outputStream, true);
                    printWriter.println("Hello! Enter exit to exit.");
                    //print client input
                    boolean isExit =false;
                    while (!isExit && scanner.hasNextLine())
                    {
                        String line = scanner.nextLine();
                        printWriter.println("Echo:" + line);
                        if(line.trim().equalsIgnoreCase("exit")) isExit=true;
                    }
                }
            }

        }
    }
}
