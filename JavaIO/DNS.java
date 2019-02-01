package JavaIO;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNS {
    public static void main(String[] args) throws UnknownHostException {

        String ipAddress = InetAddress.getByName("portal.azure.cn").getHostAddress();
        System.out.println(ipAddress);

        InetAddress[] addresses = InetAddress.getAllByName("8.8.8.8");
        for (int i = 0; i < addresses.length; i++) {
            String hostName = addresses[i].getHostName();
            System.out.println(hostName);
        }

    }
}
