package JavaIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ThreadEchoServerDemo {
    public static void main(String[] args) {

        try{
            int i=1;
            try (ServerSocket serverSocket = new ServerSocket(9000, 1000, InetAddress.getLocalHost())) {

                while (true)
                {
                    Socket s = serverSocket.accept();
                    System.out.println("Spawning " + i);
                    Runnable runnable = new ThreadEchoHandler(s);
                    Thread thread = new Thread(runnable);
                    thread.start();
                    i++;
                }
            }
        }catch (UnknownHostException e)
        {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}

class ThreadEchoHandler implements Runnable{
    private Socket incoming;
    public ThreadEchoHandler(Socket socket)
    {
        incoming = socket;

    }

    @Override
    public void run() {
        try
        {
            try{
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                Scanner in = new Scanner(inputStream);
                PrintWriter out = new PrintWriter(outputStream, true);
                out.println("Enter bye to exit!");
                //echo client request

                boolean isDone = false;
                while (!isDone && in.hasNextLine())
                {
                    String line = in.nextLine();
                    out.println("Echo:" + line);
                    if(line.trim().equalsIgnoreCase("bye")) isDone=true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                incoming.close();
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
