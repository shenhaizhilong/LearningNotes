package JavaNetWorking;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ListAllNic {
    public static void main(String[] args) {
        try
        {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements())
            {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println(ni);
            }
        }catch (SocketException ex)
        {
            ex.printStackTrace();
        }

    }
}
