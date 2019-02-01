package JavaNetWorking;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NicDemo {

    public static void main(String[] args) {
        try
        {
            InetAddress local = InetAddress.getByName("127.0.0.1");
            NetworkInterface ni = NetworkInterface.getByInetAddress(local);

            if(ni != null)
            {
                System.out.println(ni);
            }
        }catch (UnknownHostException ex)
        {
            System.out.println(ex);
        }catch (SocketException ex)
        {
            ex.printStackTrace();
        }
    }
}
