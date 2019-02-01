package JavaIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketDemo1 {

    public static void main(String[] args) {
        try(Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {

            InputStream stream = socket.getInputStream();
            Scanner scanner = new Scanner(stream);
            System.out.println("HostName:" + socket.getInetAddress().getHostName());
            System.out.println("Address:" + socket.getInetAddress().getHostAddress());
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
